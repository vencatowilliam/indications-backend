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
import com.vencato.indications.domain.enums.SaleStatus;

@Entity
public class Sale implements Serializable {
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

	private String observations;
	private SaleStatus saleStatus = SaleStatus.NEW;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate creationDate = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate closingDate;
	
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sale(Integer id, String description, Producer producer, Indication indication, String observations) {
		super();
		this.id = id;
		this.description = description;
		this.producer = producer;
		this.indication = indication;
		this.observations = observations;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

	public Indication getIndication() {
		return indication;
	}
	public void setIndication(Indication indication) {
		this.indication = indication;
	}

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}

	public SaleStatus getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(SaleStatus saleStatus) {
		this.saleStatus = saleStatus;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}
}
