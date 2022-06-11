package com.vencato.indications.domain;

import java.time.LocalDate;

public class Campaign {

	private Integer ID;
	private String description;
	private Producer producer;
	private LocalDate creationDate = LocalDate.now();
	private LocalDate starts;
	private LocalDate ends;
	private String observations;
	
	public Campaign() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Campaign(Integer iD, String description, Producer producer, LocalDate starts, LocalDate ends,
			String observations) {
		super();
		ID = iD;
		this.description = description;
		this.producer = producer;
		this.starts = starts;
		this.ends = ends;
		this.observations = observations;
	}

	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public LocalDate getStarts() {
		return starts;
	}
	public void setStarts(LocalDate starts) {
		this.starts = starts;
	}

	public LocalDate getEnds() {
		return ends;
	}
	public void setEnds(LocalDate ends) {
		this.ends = ends;
	}

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
}
