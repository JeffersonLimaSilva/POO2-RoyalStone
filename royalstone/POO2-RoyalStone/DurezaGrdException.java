//Jefferson Lima Silva ra:2601419
public class DurezaGrdException extends Exception{

	Leitura l= new Leitura();
	public void impDGrd(){
		System.out.println("\ncatch de Dureza -> Dureza <=10");
	}


	public MineralPrecioso corDGrd(MineralPrecioso min){
		try{
			min.setDureza(Integer.parseInt(l.entDados("\nDureza(Ex:3): ")));
			min.setPeso(Float.parseFloat(l.entDados("\nPeso(Ex:100g): ")));
			min.setValorComercial(Double.parseDouble(l.entDados("\nValor Comecial(Ex:2.900 / Quilates): ")));
		}
		catch(DurezaGrdException dge){
			dge.impDGrd();
			min = dge.corDGrd(min);
		}
		catch(DurezaPqnException dpe){
			dpe.impDPqn();
			min = dpe.corDPqn(min);
		}
		catch(NumberFormatException nfe){
			System.out.println("\ncatch Number -> Infomacao nao compativel.");
		}
		return min;
	}

}
