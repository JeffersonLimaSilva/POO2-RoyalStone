//Jefferson Lima Silva ra:2601419
public class MineralMetalico extends Mineral implements RelatorioMineral{
	private float ponto_de_fusao;
	private String condutividade;

	public MineralMetalico(){
		super();
		ponto_de_fusao=0;
		condutividade="";
	}

	public MineralMetalico(String nome, String composicao_quimica, String cor, int dureza, float peso, double valor_comercial,
														 Origem origem, float ponto_de_fusao, String condutividade){
		super(nome, composicao_quimica, cor, dureza, peso, valor_comercial, origem);
		this.ponto_de_fusao= ponto_de_fusao;
		this.condutividade=condutividade;
	}
	public String GerarRelatorio(){
		return  "----------------------------------------------------------------------\n"+
						"|                      Relatório de Mineral Metálico:\n" +
						"----------------------------------------------------------------------\n"+
						"| Nome                | " + getNome() + "\n" +
						"----------------------------------------------------------------------\n"+
						"| Composição Química  | " + getComposicaoQuimica() + "\n" +
						"----------------------------------------------------------------------\n"+
						"| Cor                 | " + getCor() + "\n" +
						"----------------------------------------------------------------------\n"+
						"| Dureza              | " + getDureza() + "\n" +
						"----------------------------------------------------------------------\n"+
						"| Peso                | " + getPeso() + "g\n" +
						"----------------------------------------------------------------------\n"+
						"| Origem              | " + getOrigem().getPais() + ", " + getOrigem().getCidade() + "\n" +
						"----------------------------------------------------------------------\n"+
						"| Tipo de Extracao    | " + getOrigem().getTipo_Extracao() + "\n" +
						"----------------------------------------------------------------------\n"+
						"| Valor Comercial     | " + getValorComercial() + "\n" +
						"----------------------------------------------------------------------\n"+
						"| Ponto de Fusão      | " + ponto_de_fusao + "°C\n" +
						"----------------------------------------------------------------------\n"+
						"| Condutividade       | " + condutividade +"\n"+
						"----------------------------------------------------------------------\n";
	}
	public float getPonto_de_Fusao(){
		return ponto_de_fusao;
	}
	public String getCondutivida(){
		return condutividade;
	}
	public void setPonto_de_Fusao(float ponto_de_fusao){
		this.ponto_de_fusao=ponto_de_fusao;
	}
	public void setCondutividade(String condutividade){
		this.condutividade=condutividade;
	}
	public String UsoMineralMetalico() {
    if (getPonto_de_Fusao() >= 0 && getPonto_de_Fusao() < 200) {
        return "\nPossível Uso Do Mineral Metálico\n" +
               "----------------------------------------------------------------------\n" +
               "| Ponto de Fusão  |                Possível Uso                      |\n" +
               "----------------------------------------------------------------------\n" +
               "|    0 - 200°C    |     Soldas, fusíveis, revestimentos de cabos     |\n" +
               "----------------------------------------------------------------------";
    } else if (getPonto_de_Fusao() >= 200 && getPonto_de_Fusao() < 800) {
        return "\nPossível Uso Do Mineral Metálico\n" +
               "----------------------------------------------------------------------\n" +
               "| Ponto de Fusão  |                Possível Uso                      |\n" +
               "----------------------------------------------------------------------\n" +
               "|   200 - 800°C   |         Recipientes de alimentos, componentes    |\n" +
							 "|                 |               automotivos, galvanização          |\n" +
               "----------------------------------------------------------------------\n";
    }
		else if (getPonto_de_Fusao() >= 800 && getPonto_de_Fusao() < 1600) {
        return "\nPossível Uso Do Mineral Metálico\n" +
               "----------------------------------------------------------------------\n" +
               "| Ponto de Fusão  |                Possível Uso                      |\n" +
               "----------------------------------------------------------------------\n" +
               "|   800 - 1600°C  | Fiação elétrica, joalheria, utensílios de cozinha|\n" +
               "----------------------------------------------------------------------";
    } else if (getPonto_de_Fusao() >= 1600 && getPonto_de_Fusao() < 3000) {
        return "\nPossível Uso Do Mineral Metálico\n" +
               "----------------------------------------------------------------------\n" +
               "| Ponto de Fusão  |                Possível Uso                      |\n" +
               "----------------------------------------------------------------------\n" +
               "|  1600 - 3000°C  |Estruturas de construção, motores de combustão, 	 |\n" +
							 "|									|	turbinas a gás      												     |\n" +
               "----------------------------------------------------------------------";
    } else if (getPonto_de_Fusao() >= 3000) {
        return "\nPossível Uso Do Mineral Metálico\n" +
               "----------------------------------------------------------------------\n" +
               "| Ponto de Fusão  |                Possível Uso                      |\n" +
               "----------------------------------------------------------------------\n" +
               "| Acima de 3000°C | Filamentos de lâmpadas, materiais de corte       |\n" +
							 "|									|	industrial, componentes aeroespaciais            |\n" +
               "----------------------------------------------------------------------";
    } else {
        return "Dados inválidos. Ponto de fusão deve ser um valor positivo.";
    }
}
	//Polimofismo por Sobrescrita
	public String Valor_para_Venda(){
		return "\n----------------------------------------------------------------------\n"+
					 	 "| Valor para Venda | " + (getValorComercial()/0.2)*getPeso() + "\n" +
						 "----------------------------------------------------------------------\n";
	}
}
