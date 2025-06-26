package br.com.royalstone.model;

import jakarta.persistence.*;

@Embeddable
public class Endereco {
	private String rua;
	private String cidade;
	
	public Endereco() {
    }

    public Endereco(String rua, String cidade) {
        this.rua = rua;
        this.cidade = cidade;
    }
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}
