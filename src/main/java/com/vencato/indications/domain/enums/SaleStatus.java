package com.vencato.indications.domain.enums;

public enum SaleStatus {
	NEW(0, "NEW"), IN_PROGRESS(1, "IN PROGRESS"), PENDING(2, "PENDING"),
		DONE_DEAL(3, "DONE_DEAL"), SALE_CANCELED(4, "SALE CANCELED");

	private Integer ID;
	private String description;

	private SaleStatus(Integer iD, String description) {
		ID = iD;
		this.description = description;
	}

	public Integer getID() {
		return ID;
	}
	public String getDescription() {
		return description;
	}

	public static SaleStatus toEnum(Integer id) {
		if(id == null) {
			return null;
		}

		for(SaleStatus x : SaleStatus.values()) {
			if(id.equals(x.getID())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Status inválido!");
	}
}
