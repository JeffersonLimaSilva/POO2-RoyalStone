package br.com.royalstone.model;

public class MineralMetalico extends Mineral {
	private int pontoFusao;
	private Joia joia;

	public int getPontoFusao() {
		return pontoFusao;
	}

	public void setPontoFusao(int pontoFusao) {
		this.pontoFusao = pontoFusao;
	}

	public Joia getJoia() {
		return joia;
	}

	public void setJoia(Joia joia) {
		this.joia = joia;
	}
	
}
