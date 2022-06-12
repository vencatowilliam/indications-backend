package com.vencato.indications.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.vencato.indications.domain.enums.DocumentType;
import com.vencato.indications.domain.enums.Profile;

@Entity
public class Producer extends User{
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "producer")
	private List<Indication> indications;

	@OneToMany(mappedBy = "producer")
	private List<Campaign> campaigns;

	@OneToMany(mappedBy = "producer")
	private List<Sale> sales;

	public Producer() {
		super();
		addProfile(Profile.PRODUCER);
	}
	public Producer(Integer id, String description, DocumentType documentType, String document, String email,
			Integer ddd, Integer phone) {
		super(id, description, documentType, document, email, ddd, phone);
		addProfile(Profile.PRODUCER);
	}

	public List<Indication> getIndications() {
		return indications;
	}
	public void setIndications(List<Indication> indications) {
		this.indications = indications;
	}

	public List<Campaign> getCampaigns() {
		return campaigns;
	}
	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}
}
