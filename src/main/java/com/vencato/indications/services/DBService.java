package com.vencato.indications.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vencato.indications.domain.Campaign;
import com.vencato.indications.domain.Indication;
import com.vencato.indications.domain.Indicator;
import com.vencato.indications.domain.Producer;
import com.vencato.indications.domain.enums.DocumentType;
import com.vencato.indications.repositories.CampaignRepository;
import com.vencato.indications.repositories.IndicationRepository;
import com.vencato.indications.repositories.IndicatorRepository;
import com.vencato.indications.repositories.ProducerRepository;

@Service
public class DBService {
	
	@Autowired
	private ProducerRepository producerRepository;
	@Autowired
	private CampaignRepository campaignRepository;
	@Autowired
	private IndicatorRepository indicatorRepository;
	@Autowired
	private IndicationRepository indicationRepository;

	public void dbInstantiate() {
		Producer producer1 = new Producer(null, "AJ Corretora", DocumentType.CNPJ, "18992795000127", "aj@aj.com.br",
				51, 998965544);

		Campaign campaign1 = new Campaign(null, "Consorcios de imóvel 300k", producer1,
				LocalDate.parse("01-06-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
				LocalDate.parse("31-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Nova campanha semestral.");

		Indicator indicator1 = new Indicator(null, "William", DocumentType.CPF, "99283835026", "wv@terra.com.br",
				51, 981932222);
		Indicator indicator2 = new Indicator(null, "Rosane", DocumentType.CPF, "24652625057", "rp@terra.com.br",
				51, 981934444);
		Indicator indicator3 = new Indicator(null, "Gilson", DocumentType.CPF, "16176938040", "gl@terra.com.br",
				51, 981935555);

		Indication indication1 = new Indication(null, "Indicando Angélica, telefone 51996955555", indicator1,
				campaign1, producer1, null, "Ligar no final da tarde.");
		Indication indication2 = new Indication(null, "Indicando Noeli, telefone 51996966666", indicator1,
				campaign1, producer1, null, "Ligar pela manhã.");
		Indication indication3 = new Indication(null, "Indicando Beti, telefone 51996977777", indicator2,
				campaign1, producer1, null, "Ligar no final do mês de Agosto.");
		Indication indication4 = new Indication(null, "Indicando Belamar, telefone 51996988888", indicator3,
				campaign1, producer1, null, "Ligar o mais rápido possível.");

		producerRepository.saveAll(Arrays.asList(producer1));
		campaignRepository.saveAll(Arrays.asList(campaign1));
		indicatorRepository.saveAll(Arrays.asList(indicator1,indicator2,indicator3));
		indicationRepository.saveAll(Arrays.asList(indication1,indication2,indication3,indication4));
	}
}
