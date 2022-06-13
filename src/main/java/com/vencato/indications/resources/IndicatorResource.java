package com.vencato.indications.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping
	public ResponseEntity<IndicatorDTO> create(@RequestBody IndicatorDTO objDTO) {
		Indicator newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
} 
 