package br.com.royalstone.model;

public class MineralPrecioso extends Mineral {
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
