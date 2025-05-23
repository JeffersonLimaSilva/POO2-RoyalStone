//Jefferson Lima Silva ra:2601419
public class MineralPrecioso extends Mineral implements GerarRelatorio{
	private String certificado;
	private String refinamento;

	//Polimorfismo por Sobrecarga
	public MineralPrecioso(){
		super();
		certificado="";
		refinamento="";
	}
	public String GerarRelatorio(){
		return null;
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
