package br.com.royalstone.model;

import br.com.royalstone.enums.CorMineral;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance; // IMPORTANTE: Nova importação
import jakarta.persistence.InheritanceType; // IMPORTANTE: Nova importação
import jakarta.persistence.Table;

@Entity
@Table(name = "mineral")
@Inheritance(strategy = InheritanceType.JOINED) // IMPORTANTE: Nova anotação
public class Mineral {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;    
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "composicao_quimica")
	private String composicaoQuimica;
	
	@Enumerated(EnumType.STRING)
	private CorMineral cor; // Este campo é específico de Mineral, e é herdado.
	
	@Column(name = "dureza")
	private int dureza;
	
	@Column(name = "peso")
	private float peso; // Peso em gramas (ex: de uma pedra solta)
	
	@Column(name = "valor_comercial")
	private double valorComercial; // Valor comercial do mineral por unidade ou peso

	public Mineral(){
	    // Construtor padrão obrigatório para JPA
	}
	
	 public Mineral(String nome, String composicaoQuimica, CorMineral cor, int dureza, float peso, double valorComercial) {
        this.nome = nome;
        this.composicaoQuimica = composicaoQuimica; // Corrigido para usar o nome do campo
        this.cor = cor;
        this.dureza = dureza;
        this.peso = peso;
        this.valorComercial = valorComercial;
    }
	
	 // --- GETTERS E SETTERS ---
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	public String getNome(){
		return nome;
	}
	public String getComposicaoQuimica(){
		return composicaoQuimica;
	}
	public CorMineral getCor(){
		return cor;
	}
	public int getDureza(){
		return dureza;
	}
	public float getPeso(){
		return peso;
	}
	public double getValorComercial(){
		return valorComercial;
	}

	public void setNome(String nome){
		this.nome=nome;
	}
	public void setComposicaoQuimica(String composicaoQuimica){ // Corrigido o parâmetro aqui também
		this.composicaoQuimica=composicaoQuimica;
	}
	public void setCor(CorMineral cor){
		this.cor=cor;
	}
	public void setDureza(int dureza){
		this.dureza=dureza;
	}
	public void setPeso(float peso){
		this.peso=peso;
	}
	public void setValorComercial(double valorComercial){ // Corrigido o parâmetro aqui também
		this.valorComercial=valorComercial;
	}
}