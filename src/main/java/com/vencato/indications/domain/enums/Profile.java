package com.vencato.indications.domain.enums;

public enum Profile {

	//INDICATED, INDICATOR, PRODUCER;

	INDICATOR(0, "INDICATOR"), PRODUCER(1, "PRODUCER");

	private Integer id;
	private String description;

	private Profile(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}

	public static Profile toEnum(Integer id) {
		if(id == null) {
			return null;
		}

		for(Profile x : Profile.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Perfil inválido!");
	}
}
