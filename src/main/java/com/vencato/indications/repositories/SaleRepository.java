package com.vencato.indications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vencato.indications.domain.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>{

}
