package com.vencato.indications.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vencato.indications.domain.Indicator;
import com.vencato.indications.domain.User;
import com.vencato.indications.dtos.IndicatorDTO;
import com.vencato.indications.repositories.IndicatorRepository;
import com.vencato.indications.repositories.UserRepository;
import com.vencato.indications.services.exceptions.DataIntegrityViolationException;
import com.vencato.indications.services.exceptions.ObjectNotFoundException;

@Service
public class IndicatorService {

	@Autowired
	private IndicatorRepository repository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Indicator findById(Integer id) {
		Optional<Indicator> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Indicator> findAll() {
		return repository.findAll();
	}

	public Indicator create(IndicatorDTO objDTO) {
		objDTO.setId(null);
		validateByDocAndEmail(objDTO);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		Indicator newObj = new Indicator(objDTO);
		return repository.save(newObj);
	}

	private void validateByDocAndEmail(IndicatorDTO objDTO) {
		Optional<User> obj = userRepository.findByDocument(objDTO.getDocument());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Documento já cadastrado no sistema!");
		}

		obj = userRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
		}
	}
}
