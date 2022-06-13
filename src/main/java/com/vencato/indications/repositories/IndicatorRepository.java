package com.vencato.indications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vencato.indications.domain.Indicator;

public interface IndicatorRepository extends JpaRepository<Indicator, Integer>{

}
