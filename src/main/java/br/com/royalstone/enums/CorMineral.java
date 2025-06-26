package br.com.royalstone.enums;

//Enum de CorMineral para uma Cor de Joia
public enum CorMineral {
	VERMELHO("Vermelho"),
	AZUL("Azul"),
	AMARELO("Amarelo"),
	VERDE("Verde"),
	INCOLOR("Incolor"),
	ROSA("Rosa"),
	BRANCO("Branco"),
	PRETO("Preto");	
	
	private final String nomeExibicao;
	
	private CorMineral(String nomeExibicao) {
		this.nomeExibicao = nomeExibicao;
	}
	
	public String getNomeExibicao() {
		return nomeExibicao;
	}

}
