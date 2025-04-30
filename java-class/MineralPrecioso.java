//Jefferson Lima Silva ra:2601419
public class MineralPrecioso extends Mineral implements RelatorioMineral{
	private String certificado;
	private String refinamento;

	//Polimorfismo por Sobrecarga
	public MineralPrecioso(){
		super();
		certificado="";
		refinamento="";
	}
	public MineralPrecioso(String nome, String composicao_quimica, String cor, int dureza, float peso,  double valor_comercial,
														 Origem origem, String certificado, String refinamento){
		super(nome, composicao_quimica, cor, dureza, peso, valor_comercial, origem);
		this.certificado=certificado;
		this.refinamento=refinamento;
	}
	public String GerarRelatorio(){
		return  "----------------------------------------------------------------------\n"+
						"|                      Relatório de Mineral Precioso:\n" +
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
						"| Certificado         | " + certificado + "\n" +
						"----------------------------------------------------------------------\n"+
						"| Refinamento         | " + refinamento +"\n"+
						"----------------------------------------------------------------------\n";

	}
	public String getCertificado(){
		return certificado;
	}
	public String getRefinamento(){
		return refinamento;
	}
	public void setCertificado(String certificado){
		this.certificado=certificado;
	}
	public void setRefinamento(String refinamento){
		this.refinamento=refinamento;
	}
	//Polimofismo por Sobrescrita
	public String Valor_para_Venda(){
		return "\n----------------------------------------------------------------------\n"+
					 	 "| Valor para Venda | " + (getValorComercial()/0.2)*getPeso() + "\n" +
						 "----------------------------------------------------------------------\n";
	}
}
