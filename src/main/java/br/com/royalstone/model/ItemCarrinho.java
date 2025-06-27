package br.com.royalstone.model;

import java.math.BigDecimal;

public class ItemCarrinho {
    private Long joiaId;
    private String nomeJoia;
    private BigDecimal precoUnitario;
    private int quantidade;
    private String imagemUrl; // Para exibir no carrinho

    // Construtor
    public ItemCarrinho(Long joiaId, String nomeJoia, BigDecimal precoUnitario, int quantidade, String imagemUrl) {
        this.joiaId = joiaId;
        this.nomeJoia = nomeJoia;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.imagemUrl = imagemUrl;
    }

    // Calcular o subtotal do item
    public BigDecimal getSubtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    // Getters e Setters
    public Long getJoiaId() {
        return joiaId;
    }

    public void setJoiaId(Long joiaId) {
        this.joiaId = joiaId;
    }

    public String getNomeJoia() {
        return nomeJoia;
    }

    public void setNomeJoia(String nomeJoia) {
        this.nomeJoia = nomeJoia;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void aumentarQuantidade(int valor) {
        this.quantidade += valor;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}