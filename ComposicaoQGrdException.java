//Jefferson Lima Silva ra:2601419
public class ComposicaoQGrdException extends Exception{
	Leitura l= new Leitura();
	public void impCQGrd(){
		System.out.println("\ncatch de Formula Quimica -> Formula Quimica < 10");
	}


	public MineralPrecioso corCQGrd(MineralPrecioso min){
		try{
			min.setComposicaoQuimica(l.entDados("\nComposicao Quimica(Ex:C): "));
			min.setDureza(Integer.parseInt(l.entDados("\nDureza(Ex:3): ")));
			min.setPeso(Float.parseFloat(l.entDados("\nPeso(Ex:100g): ")));
			min.setValorComercial(Double.parseDouble(l.entDados("\nValor Comecial(Ex:2.900 / Quilates): ")));
		}
		catch(ComposicaoQGrdException cge){
			cge.impCQGrd();
			min = cge.corCQGrd(min);
		}
		catch(DurezaPqnException dpe){
			dpe.impDPqn();
			min = dpe.corDPqn(min);
		}
		catch(DurezaGrdException dge){
			dge.impDGrd();
			min = dge.corDGrd(min);
		}
		catch(NumberFormatException nfe){
			System.out.println("\ncatch Number -> Infomacao nao compativel.");
		}
		return min;
	}

}
