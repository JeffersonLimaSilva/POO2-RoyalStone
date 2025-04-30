//Jefferson Lima Silva ra:2601419
public class MineralNaoMetalico extends Mineral{
	private String transparencia;
	private String isolamento;

	public MineralNaoMetalico(){
		super();
		transparencia="";
		isolamento="";
	}
	public MineralNaoMetalico(String nome, String composicao_quimica, String cor, int dureza, float peso, double valor_comercial,
														 Origem origem, String transparencia, String isolamento) {
			 super(nome, composicao_quimica, cor, dureza, peso, valor_comercial, origem);
			 this.transparencia = transparencia;
			 this.isolamento = isolamento;
	}
	public String GerarRelatorio(){
		return  "----------------------------------------------------------------------\n"+
						"|                    Relatório de Mineral Não Metálico:\n" +
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
						"| Transparência       | " + transparencia + "\n" +
						"----------------------------------------------------------------------\n"+
						"| Isolamento          | " + isolamento +"\n"+
						"----------------------------------------------------------------------\n";
	}
	public String getTransparencia(){
		return transparencia;
	}
	public void setTransparencia(String transparencia){
		this.transparencia=transparencia;
	}
	public String getIsolamento(){
		return isolamento;
	}
	public void setIsolamento(String isolamento){
		this.isolamento=isolamento;
	}
	//Polimofismo por Sobrescrita
	public String Valor_para_Venda(){
		return "\n----------------------------------------------------------------------\n"+
					 	 "| Valor para Venda | " + (getValorComercial()/0.2)*getPeso() + "\n" +
						 "----------------------------------------------------------------------\n";
	}
}
