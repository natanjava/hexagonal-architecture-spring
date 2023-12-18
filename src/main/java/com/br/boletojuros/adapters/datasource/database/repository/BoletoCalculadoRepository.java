package com.br.boletojuros.adapters.datasource.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.boletojuros.adapters.datasource.database.entity.BoletoCalculadoEntity;

@Repository
public interface BoletoCalculadoRepository extends JpaRepository<BoletoCalculadoEntity, Long> {
}
