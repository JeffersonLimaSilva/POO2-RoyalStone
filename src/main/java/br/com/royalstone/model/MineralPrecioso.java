package br.com.royalstone.model;

import br.com.royalstone.enums.CorMineral;

public class MineralPrecioso extends Mineral {
	public MineralPrecioso(String nome, String composicao_quimica, CorMineral cor, int dureza, float peso,
			double valor_comercial) {
		super(nome, composicao_quimica, cor, dureza, peso, valor_comercial);
		
	}
	private String certificado;
	private String refinamento;
	private Joia joia;
	
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	public String getRefinamento() {
		return refinamento;
	}
	public void setRefinamento(String refinamento) {
		this.refinamento = refinamento;
	}
	public Joia getJoia() {
		return joia;
	}
	public void setJoia(Joia joia) {
		this.joia = joia;
	}
	
}
