package com.vencato.indications.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vencato.indications.domain.Indicator;
import com.vencato.indications.domain.enums.DocumentType;
import com.vencato.indications.domain.enums.Profile;

public class IndicatorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	protected Integer id;
	protected String description;
	protected Set<Integer> profiles = new HashSet<>();
	protected DocumentType documentType;
	protected String document;
	protected String email;
	protected Integer DDD;
	protected Integer phone;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate creationDate = LocalDate.now();

	public IndicatorDTO() {
		super();
	}

	public IndicatorDTO(Indicator obj) {
		super();
		this.id = obj.getId();
		this.description = obj.getDescription();
		this.profiles = obj.getProfiles().stream().map(x -> x.getId()).collect(Collectors.toSet());
		this.documentType = obj.getDocumentType();
		this.document = obj.getDocument();
		this.email = obj.getEmail();
		DDD = obj.getDDD();
		this.phone = obj.getPhone();
		this.creationDate = obj.getCreationDate();
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

	public Set<Profile> getProfiles() {
		return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}
	public void addProfiles(Profile profile) {
		this.profiles.add(profile.getId());
	}

	public DocumentType getDocumentType() {
		return documentType;
	}
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDDD() {
		return DDD;
	}
	public void setDDD(Integer dDD) {
		DDD = dDD;
	}

	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
}
