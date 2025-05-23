//Jefferson Lima Silva ra:2601419

public abstract class Mineral{
        private int codIdentificador;
	private String nome;
	private String composicao_quimica;
	private String cor;
	private int dureza;
	private float peso;
	private double valor_comercial;
	private Origem origem;

	public Mineral() {
                codIdentificador=0;
		nome = "";
		composicao_quimica = "";
		cor = "";
		dureza = 0;
		peso = 0;
		valor_comercial = 0.0;
		origem = new Origem("","","");
	}
        public int getCodIdentificador(){
            return codIdentificador;
	}
	public String getNome(){
            return nome;
	}
	public String getComposicaoQuimica(){
            return composicao_quimica;
	}
	public String getCor(){
            return cor;
	}
	public int getDureza(){
            return dureza;
	}
	public float getPeso(){
            return peso;
	}
	public double getValorComercial(){
            return valor_comercial;
	}
	public Origem getOrigem(){
            return origem;
	}
        public void setCodIdentificador(int codIdentificador){
            this.codIdentificador=codIdentificador;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public void setComposicaoQuimica(String composicao_quimica) throws ComposicaoQGrdException{
            if(composicao_quimica.length()<=10){
                this.composicao_quimica=composicao_quimica;
            }
            else{
                throw new ComposicaoQGrdException();
            }
	}
	public void setCor(String cor){
		this.cor=cor;
	}
	public void setDureza(int dureza) throws DurezaPqnException, DurezaGrdException{
		if(dureza > 0){
			if (dureza <=10) {
				this.dureza=dureza;
			}
			else{
				throw new DurezaGrdException();
			}
		}
		else{
			throw new DurezaPqnException();
		}
	}
	public void setPeso(float peso){
            this.peso=peso;
	}
	public void setValorComercial(double valor_comercial){
            this.valor_comercial=valor_comercial;
	}
	public void setOrigem(Origem origem){
            this.origem=origem;
	}
	abstract String Valor_para_Venda();

}
