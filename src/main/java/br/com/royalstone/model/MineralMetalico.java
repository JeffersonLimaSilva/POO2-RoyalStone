// br.com.royalstone.model.MineralMetalico.java (Verifique este arquivo)

package br.com.royalstone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal; // Importe BigDecimal

@Entity
public class MineralMetalico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double pureza; // Ex: 0.999 para ouro puro
    private BigDecimal precoPorGrama; // Preço do metal por grama
    private int estoqueGrama; // Estoque em gramas

    // CONSTRUTOR PADRÃO (OBRIGATÓRIO PARA JPA)
    public MineralMetalico() {}

    // ESTE CONSTRUTOR PRECISA EXISTIR PARA O DATALOADER FUNCIONAR
    public MineralMetalico(String nome, double pureza, BigDecimal precoPorGrama, int estoqueGrama) {
        this.nome = nome;
        this.pureza = pureza;
        this.precoPorGrama = precoPorGrama;
        this.estoqueGrama = estoqueGrama;
    }

    // Getters e Setters (Certifique-se de que estão corretos)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPureza() { return pureza; }
    public void setPureza(double pureza) { this.pureza = pureza; }
    public BigDecimal getPrecoPorGrama() { return precoPorGrama; }
    public void setPrecoPorGrama(BigDecimal precoPorGrama) { this.precoPorGrama = precoPorGrama; }
    public int getEstoqueGrama() { return estoqueGrama; }
    public void setEstoqueGrama(int estoqueGrama) { this.estoqueGrama = estoqueGrama; }
}