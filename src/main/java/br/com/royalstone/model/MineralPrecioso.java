// br.com.royalstone.model.MineralPrecioso.java (Verifique este arquivo)

package br.com.royalstone.model;

import br.com.royalstone.enums.CorMineral;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.math.BigDecimal;

@Entity
public class MineralPrecioso extends Mineral {
	// CONSTRUTOR PADRÃO (OBRIGATÓRIO PARA JPA)
	public MineralPrecioso() {
		super(); // Chama o construtor padrão da superclasse Mineral
	}

	// ESTE CONSTRUTOR PRECISA EXISTIR E CHAMAR O CONSTRUTOR DA SUPERCLASSE CORRETAMENTE
	// Baseado nos parâmetros do DataLoader
	public MineralPrecioso(String nome, String composicao_quimica, CorMineral cor, int dureza, float peso,
			double valor_comercial) {
		super(nome, composicao_quimica, cor, dureza, peso, valor_comercial);
		// Inicialize aqui outros campos específicos de MineralPrecioso se necessário
	}

	private String certificado;
	private String refinamento;
	// Certifique-se de que estes campos estão aqui, com getters/setters
	private BigDecimal pesoQuilates;
	private BigDecimal precoPorQuilate;
	private String lapidacao;
	
    @Enumerated(EnumType.STRING)
    private CorMineral cor; // Se este campo também está em Mineral, pode haver duplicação ou necessidade de anotação @Transient

	// Getters e Setters
	public String getCertificado() { return certificado; }
	public void setCertificado(String certificado) { this.certificado = certificado; }
	public String getRefinamento() { return refinamento; }
	public void setRefinamento(String refinamento) { this.refinamento = refinamento; }
	public BigDecimal getPesoQuilates() { return pesoQuilates; }
	public void setPesoQuilates(BigDecimal pesoQuilates) { this.pesoQuilates = pesoQuilates; }
	public BigDecimal getPrecoPorQuilate() { return precoPorQuilate; }
	public void setPrecoPorQuilate(BigDecimal precoPorQuilate) { this.precoPorQuilate = precoPorQuilate; }
	public String getLapidacao() { return lapidacao; }
	public void setLapidacao(String lapidacao) { this.lapidacao = lapidacao; }
	public CorMineral getCor() { return cor; }
	public void setCor(CorMineral cor) { this.cor = cor; }
}