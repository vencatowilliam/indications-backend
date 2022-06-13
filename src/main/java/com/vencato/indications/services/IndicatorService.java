package com.vencato.indications.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vencato.indications.domain.Indicator;
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
}
