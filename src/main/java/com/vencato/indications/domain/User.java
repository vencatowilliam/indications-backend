package com.vencato.indications.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.vencato.indications.domain.enums.DocumentType;
import com.vencato.indications.domain.enums.Profile;

public abstract class User {

	protected Integer ID;
	protected String description;
	protected Set<Profile> profile = new HashSet<>();
	protected Set<DocumentType> documentType = new HashSet<>();
	protected String document;
	protected String email;
	protected Integer DDD;
	protected Integer phone;
	protected LocalDate creationDate = LocalDate.now();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer iD, String description, Set<DocumentType> documentType, String document, String email,
			Integer dDD, Integer phone) {
		super();
		ID = iD;
		this.description = description;
		this.documentType = documentType;
		this.document = document;
		this.email = email;
		DDD = dDD;
		this.phone = phone;
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

	public Set<Profile> getProfile() {
		return profile;
	}
	public void setProfile(Set<Profile> profile) {
		this.profile = profile;
	}

	public Set<DocumentType> getDocumentType() {
		return documentType;
	}
	public void setDocumentType(Set<DocumentType> documentType) {
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

	@Override
	public int hashCode() {
		return Objects.hash(ID, document);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(document, other.document);
	}
}
