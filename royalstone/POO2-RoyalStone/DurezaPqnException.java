//Jefferson Lima Silva ra:2601419
public class DurezaPqnException extends Exception{

	Leitura l= new Leitura();
	public void impDPqn(){
		System.out.println("\ncatch de Dureza -> Dureza > 0");
	}


	public MineralPrecioso corDPqn(MineralPrecioso min){
		try{
			min.setDureza(Integer.parseInt(l.entDados("\nDureza(Ex:3): ")));
			min.setPeso(Float.parseFloat(l.entDados("\nPeso(Ex:100g): ")));
			min.setValorComercial(Double.parseDouble(l.entDados("\nValor Comecial(Ex:2.900 / Quilates): ")));
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
