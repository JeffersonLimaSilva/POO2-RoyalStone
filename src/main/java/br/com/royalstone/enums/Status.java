package br.com.royalstone.enums;


//Enum de Status para uma Joia

public enum Status {
	DISPONIVEL("Disponível"),
	INDISPONIVEL("Indisponível"),
	EM_PROMOÇÃO("Em promoção");
	
	private String status;
		private Status(String status) {
			this.status = status;
		}
		
	public String getStatus() {
		return status;
	 }
	}

