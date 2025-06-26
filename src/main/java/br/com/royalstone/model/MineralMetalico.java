package br.com.royalstone.model;

import br.com.royalstone.enums.CorMineral;

public class MineralMetalico extends Mineral {
	public MineralMetalico(String nome, String composicao_quimica, CorMineral cor, int dureza, float peso,
			double valor_comercial) {
		super(nome, composicao_quimica, cor, dureza, peso, valor_comercial);
	}

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
