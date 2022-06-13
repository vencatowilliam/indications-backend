package com.vencato.indications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vencato.indications.domain.Indication;

public interface IndicationRepository extends JpaRepository<Indication, Integer>{

}
