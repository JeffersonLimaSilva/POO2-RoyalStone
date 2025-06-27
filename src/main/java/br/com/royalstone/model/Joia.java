package br.com.royalstone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne; // Importe para relacionamentos
import jakarta.persistence.JoinColumn; // Importe para relacionamentos
import java.math.BigDecimal; // Para lidar com valores monetários

@Entity // 
public class Joia { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID para identificar a joia no banco
    private String nome; // Nome da joia (ex: "Anel de Esmeralda com Ouro")
    private String descricao; // Descrição detalhada
    private BigDecimal preco; // Preço de venda da joia
    private int estoque; // Quantidade de joias disponíveis
    private String imagemUrl; // URL para a imagem da joia

    // Relacionamento com MineralPrecioso (a gema)
    @ManyToOne // Uma joia tem um mineral precioso, mas um mineral precioso pode estar em várias joias
    @JoinColumn(name = "mineral_precioso_id") // Coluna na tabela Joia que referencia o ID do MineralPrecioso
    private MineralPrecioso mineralPrecioso; // Renomeado de 'precioso' para melhor clareza do objeto

    // Relacionamento com MineralMetalico (o metal)
    @ManyToOne // Uma joia tem um mineral metálico, mas um metal pode estar em várias joias
    @JoinColumn(name = "mineral_metalico_id") // Coluna na tabela Joia que referencia o ID do MineralMetalico
    private MineralMetalico mineralMetalico; // Renomeado de 'metalico'

    // Construtor padrão (obrigatório para JPA)
    public Joia() {
    }

    // --- Getters e Setters  ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public MineralPrecioso getMineralPrecioso() { // Getter ajustado
        return mineralPrecioso;
    }

    public void setMineralPrecioso(MineralPrecioso mineralPrecioso) { // Setter ajustado
        this.mineralPrecioso = mineralPrecioso;
    }

    public MineralMetalico getMineralMetalico() { // Getter ajustado
        return mineralMetalico;
    }

    public void setMineralMetalico(MineralMetalico mineralMetalico) { // Setter ajustado
        this.mineralMetalico = mineralMetalico;
    }
}