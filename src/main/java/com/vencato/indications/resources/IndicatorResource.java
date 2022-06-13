package com.vencato.indications.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vencato.indications.domain.Indicator;
import com.vencato.indications.services.IndicatorService;

@RestController
@RequestMapping(value = "/indicators")
public class IndicatorResource {

	// localhost:8080/indicators/1

	@Autowired
	private IndicatorService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Indicator> findById(@PathVariable Integer id) {
		Indicator obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
