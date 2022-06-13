package com.vencato.indications.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vencato.indications.domain.Indicator;
import com.vencato.indications.dtos.IndicatorDTO;
import com.vencato.indications.repositories.IndicatorRepository;
import com.vencato.indications.services.exceptions.ObjectNotFoundException;

@Service
public class IndicatorService {

	@Autowired
	private IndicatorRepository repository;
	
	public Indicator findById(Integer id) {
		Optional<Indicator> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Indicator> findAll() {
		return repository.findAll();
	}

	public Indicator create(IndicatorDTO objDTO) {
		objDTO.setId(null);
		Indicator newObj = new Indicator(objDTO);
		return repository.save(newObj);
	}
}
