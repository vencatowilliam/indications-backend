package com.vencato.indications;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vencato.indications.domain.Campaign;
import com.vencato.indications.domain.Indication;
import com.vencato.indications.domain.Indicator;
import com.vencato.indications.domain.Producer;
import com.vencato.indications.domain.enums.DocumentType;
import com.vencato.indications.repositories.CampaignRepository;
import com.vencato.indications.repositories.IndicationRepository;
import com.vencato.indications.repositories.IndicatorRepository;
import com.vencato.indications.repositories.ProducerRepository;

@SpringBootApplication
public class IndicationsApplication implements CommandLineRunner {

	@Autowired
	private ProducerRepository producerRepository;
	@Autowired
	private CampaignRepository campaignRepository;
	@Autowired
	private IndicatorRepository indicatorRepository;
	@Autowired
	private IndicationRepository indicationRepository;

	public static void main(String[] args) {
		SpringApplication.run(IndicationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Producer producer1 = new Producer(null, "AJ Corretora", DocumentType.CNPJ, "18992795000127", "aj@aj.com.br",
				51, 998965544);

		Campaign campaign1 = new Campaign(null, "Consorcios de imóvel 300k", producer1,
				LocalDate.parse("01-06-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
				LocalDate.parse("31-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Nova campanha semestral.");

		Indicator indicator1 = new Indicator(null, "William Pinheiro", DocumentType.CPF, "99283835026", "wv@terra.com.br",
				51, 981932743);

		Indication indication1 = new Indication(null, "Indicando Angélica Silva, telefone 51996957766", indicator1,
				campaign1, producer1, null, "Ligar no final da tarde.");

		producerRepository.saveAll(Arrays.asList(producer1));
		campaignRepository.saveAll(Arrays.asList(campaign1));
		indicatorRepository.saveAll(Arrays.asList(indicator1));
		indicationRepository.saveAll(Arrays.asList(indication1));
	}
}
