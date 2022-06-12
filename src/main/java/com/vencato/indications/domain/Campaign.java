package com.vencato.indications.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Campaign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String description;

	@ManyToOne
	@JoinColumn(name = "producer_id")
	private Producer producer;

	@OneToOne
	@JoinColumn(name = "indication_id")
	private Indication indication;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate creationDate = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate starts;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate ends;

	private String observations;
	
	public Campaign() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Campaign(Integer id, String description, Producer producer, LocalDate starts, LocalDate ends,
			String observations) {
		super();
		this.id = id;
		this.description = description;
		this.producer = producer;
		this.starts = starts;
		this.ends = ends;
		this.observations = observations;
	}

	public Integer getId() {
		return id;
	}
	public void setID(Integer id) {
		this.id = id;
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
