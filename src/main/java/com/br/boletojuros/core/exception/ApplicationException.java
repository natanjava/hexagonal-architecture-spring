package com.br.boletojuros.core.exception;

import com.br.boletojuros.core.domain.enums.TipoExcecao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
    private TipoExcecao tipoExcecao;
    
}
