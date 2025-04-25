//Jefferson Lima Silva ra:2601419
public class Origem{
	String pais;
	String cidade;
	String tipo_extracao;

	public Origem(){
		pais="";
		cidade="";
		tipo_extracao="";
	}
  public Origem(String pais, String cidade, String tipo_extracao) {
      this.pais = pais;
      this.cidade = cidade;
      this.tipo_extracao = tipo_extracao;
  }
	public String getPais(){
		return pais;
	}
	public String getCidade(){
		return cidade;
	}
	public String getTipo_Extracao(){
		return tipo_extracao;
	}

	public void setPais(String pais){
		this.pais=pais;
	}
	public void setCidade(String cidade){
		this.cidade=cidade;
	}
	public void setTipo_Extracao(String tipo_extracao){
		this.tipo_extracao=tipo_extracao;
	}
}
