package br.com.royalstone.model;

import br.com.royalstone.enums.CorMineral;
import jakarta.persistence.Column;
import jakarta.persistence.Entity; // Importação para o Entity, do banco de dados.
import jakarta.persistence.EnumType; //Importação para o JPA
import jakarta.persistence.Enumerated; // Importação para o Enumerated
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mineral")
public class Mineral{
	
	@Id // Marca este campo como a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura o banco de dados para gerar o ID automaticamente
	
	@Column(name = "id")
    private Long id; 

	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "composicao_quimica")
	private String composicaoQuimica;
	
	@Enumerated(EnumType.STRING)
	private CorMineral cor;
	
	@Column(name = "dureza")
	private int dureza;
	
	@Column(name = "peso")
	private float peso;
	
	@Column(name = "valor_comercial")
	private double valorComercial;

	public Mineral(){
	}
	
	 public Mineral(String nome, String composicao_quimica, CorMineral cor, int dureza, float peso, double valor_comercial) {
	        this.nome = nome;
	        this.composicaoQuimica = composicao_quimica;
	        this.cor = cor;
	        this.dureza = dureza;
	        this.peso = peso;
	        this.valorComercial = valor_comercial;
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
	public void setComposicaoQuimica(String composicao_quimica){
		this.composicaoQuimica=composicao_quimica;
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
	public void setValorComercial(double valor_comercial){
		this.valorComercial=valor_comercial;
	}

}
