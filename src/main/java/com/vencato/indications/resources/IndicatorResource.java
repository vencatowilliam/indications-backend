package com.vencato.indications.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vencato.indications.domain.Indicator;
import com.vencato.indications.dtos.IndicatorDTO;
import com.vencato.indications.services.IndicatorService;

@RestController
@RequestMapping(value = "/indicators")
public class IndicatorResource {

	// localhost:8080/indicators/1

	@Autowired
	private IndicatorService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<IndicatorDTO> findById(@PathVariable Integer id) {
		Indicator obj = this.service.findById(id);
		return ResponseEntity.ok().body(new IndicatorDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<IndicatorDTO>> findAll() {
		List<Indicator> list = service.findAll();
		List<IndicatorDTO> listDTO = list.stream().map(obj -> new IndicatorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
