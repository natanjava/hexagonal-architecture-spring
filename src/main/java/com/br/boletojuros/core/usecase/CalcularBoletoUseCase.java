package com.br.boletojuros.core.usecase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.br.boletojuros.core.domain.Boleto;
import com.br.boletojuros.core.domain.BoletoCalculado;
import com.br.boletojuros.core.domain.enums.TipoBoleto;
import com.br.boletojuros.core.domain.enums.TipoExcecao;
import com.br.boletojuros.core.exception.ApplicationException;
import com.br.boletojuros.core.port.in.CalculoBoletoPort;
import com.br.boletojuros.core.port.out.ComplementoBoletoPort;
import com.br.boletojuros.core.port.out.SalvarCalculoBoletoPort;

@Service
public class CalcularBoletoUseCase implements CalculoBoletoPort {

    // daily yelds
    private static final BigDecimal JUROS_DIARIO = BigDecimal.valueOf(0.033);

    /**autowired - dependencies injection */
    private final ComplementoBoletoPort complementoBoletoPort;
    private final SalvarCalculoBoletoPort salvarCalculoBoletoPort;

    public CalcularBoletoUseCase(ComplementoBoletoPort complementoBoletoPort, SalvarCalculoBoletoPort salvarCalculoBoletoPort) {
        this.complementoBoletoPort = complementoBoletoPort;
        this.salvarCalculoBoletoPort = salvarCalculoBoletoPort;
    }
    /**end - dependencies injection */


    @Override
    public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {
        
        var boleto = complementoBoletoPort.executar(codigo);
        validar(boleto);
        
        // calculating value of Bill (boleto)
        var diasVencidos = getDiasVencidos(boleto.getDataVencimento(), dataPagamento);
        var valorJurosDia = JUROS_DIARIO.multiply(boleto.getValor()).divide(new BigDecimal(100));
        var juros = valorJurosDia.multiply(new BigDecimal(diasVencidos)).setScale(2, RoundingMode.HALF_EVEN);
        
        var boletoCalculado = BoletoCalculado.builder()
            .codigo(boleto.getCodigo())
            .dataPagamento(dataPagamento)
            .juros(juros)
            .dataVencimento(boleto.getDataVencimento())
            .valorOriginal(boleto.getValor())
            .valor(boleto.getValor().add(juros))
            .tipo(boleto.getTipo())
            .build();

        // save Bill
        salvarCalculoBoletoPort.executar(boletoCalculado);
        
        
        return boletoCalculado;
    }
    
    private void validar(Boleto boleto)  {
        if (boleto == null) {
            throw new ApplicationException(TipoExcecao.BOLETO_INVALIDO);
        }
    
        if (boleto.getTipo() != TipoBoleto.XPTO) {
            throw new ApplicationException(TipoExcecao.TIPO_BOLETO_INVALIDO);
        }
    
        if (boleto.getDataVencimento().isAfter(LocalDate.now())) {
            throw new ApplicationException(TipoExcecao.BOLETO_NAO_VENCIDO);
        }
    }

    // use native function to calculate periodo between two Dates
    private Long getDiasVencidos(LocalDate dataVencimento, LocalDate dataPagamento) {
        return ChronoUnit.DAYS.between(dataVencimento, dataPagamento);
    }



}


