package com.vencato.indications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vencato.indications.domain.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Integer>{

}
