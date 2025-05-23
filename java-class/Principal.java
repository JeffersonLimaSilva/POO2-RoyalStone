//Jefferson Lima Silva ra:2601419


public class Principal{
	private static Leitura l = new Leitura();
	private static MineralPrecioso precioso= new MineralPrecioso();
	private static MineralMetalico metalico= new MineralMetalico();
	private static MineralNaoMetalico n_metalico= new MineralNaoMetalico();

	

	public static void main(String arg[]){
	

		int flag, flag3=0;
		boolean flag2=true;
		do {
				flag=Integer.parseInt(l.entDados("\nQual tipo de mineral sera cadastrado:\n\n  1-Mineral Precioso.\n  2-Mineral Metalico.\n  3-mineral Nao Metalico."));
				switch(flag){
					case 1:
						System.out.println("\nCadastro de Mineral Precioso:");
						precioso.setNome(l.entDados("\nNome(Ex:Diamante): "));
						precioso.setCor(l.entDados("\nCor(Ex:Vermelho): "));
						try{
							precioso.setComposicaoQuimica(l.entDados("\nComposicao Quimica(Ex:C): "));
							precioso.setDureza(Integer.parseInt(l.entDados("\nDureza(Ex:3): ")));
							precioso.setPeso(Float.parseFloat(l.entDados("\nPeso(Ex:100g): ")));
							precioso.setValorComercial(Double.parseDouble(l.entDados("\nValor Comecial(Ex:2.900 / Quilates): ")));
						}
						catch(ComposicaoQGrdException cge){
							cge.impCQGrd();
							
						}
						catch(DurezaPqnException dpe){
							dpe.impDPqn();
							precioso = dpe.corDPqn(precioso);
						}
						catch(DurezaGrdException dge){
							dge.impDGrd();
							precioso = dge.corDGrd(precioso);
						}
						catch(NumberFormatException nfe){
							System.out.println("\ncatch Number -> Infomacao nao compativel.");
						}
						precioso.setCertificado(l.entDados("\nCertificado(Ex:GIA (Gemological Institute of America) Certification): "));
						precioso.setRefinamento(l.entDados("\nRefinamento(Ex:Lapidada): "));
						System.out.println("\nInforma a origem do Mineral Precioso:");
						precioso.getOrigem().setPais(l.entDados("\nPais(Ex:Brasil): "));
						precioso.getOrigem().setCidade(l.entDados("\nCidade(Ex:Diamantina): "));
						precioso.getOrigem().setTipo_Extracao(l.entDados("\nTipo de Extracao(Ex:Mineracao Subterranea): "));
						System.out.println(precioso.Valor_para_Venda());
						System.out.println(precioso.GerarRelatorio());
					break;
					case 2:
						System.out.println("\nCadastro de Mineral Metalico:");
						metalico.setNome(l.entDados("\nNome(Ex:Cobre): "));
						metalico.setCor(l.entDados("\nCor(Ex:Laranja Avermelhodo): "));
						while(flag2){
							try{
								metalico.setComposicaoQuimica(l.entDados("\nComposicao Quimica(Ex:Cu): "));
								metalico.setDureza(Integer.parseInt(l.entDados("\nDureza(Ex:3): ")));
								metalico.setPeso(Float.parseFloat(l.entDados("\nPeso(Ex:100g): ")));
								metalico.setValorComercial(Double.parseDouble(l.entDados("\nValor Comecial(Ex:2.900 / Quilates): ")));
								flag2 = false;
							}
							catch(ComposicaoQGrdException cge){
								System.out.println("\ncatch de Formula Quimica -> Formula Quimica < 10");
							}
							catch(DurezaPqnException dpe){
								System.out.println("\ncatch de Dureza -> Dureza > 0");
							}
							catch(DurezaGrdException dge){
								System.out.println("\ncatch de Dureza -> Dureza <=10");
							}
							catch(NumberFormatException nfe){
								System.out.println("\ncatch Number -> Infomacao nao compativel.");
							}
						}
						metalico.setPonto_de_Fusao(Float.parseFloat(l.entDados("\nPonto de Fusao(Ex:1.084C): ")));
						metalico.setCondutividade(l.entDados("\nCondutividade(Ex:Excelente): "));
						System.out.println("\nInforma a origem do Mineral Metalico:");
						metalico.getOrigem().setPais(l.entDados("\nPais(Ex:Zambia): "));
						metalico.getOrigem().setCidade(l.entDados("\nCidade(Ex:Chingola): "));
						metalico.getOrigem().setTipo_Extracao(l.entDados("\nTipo de Extracao(Ex:Mineracao Subterranea): "));
						System.out.println(metalico.Valor_para_Venda());
						System.out.println(metalico.GerarRelatorio());
						System.out.println(metalico.UsoMineralMetalico());
					break;
					case 3:
						System.out.println("\nCadastro de Mineral Nao Metalico:");
						n_metalico.setNome(l.entDados("\nNome(Ex:Quartzo): "));
						n_metalico.setCor(l.entDados("\nCor(Ex:Transparente a Leitoso): "));
						while(flag2){
							try{
								n_metalico.setComposicaoQuimica(l.entDados("\nComposicao Quimica(Ex:SiO2): "));
								n_metalico.setDureza(Integer.parseInt(l.entDados("\nDureza(Ex:3): ")));
								n_metalico.setPeso(Float.parseFloat(l.entDados("\nPeso(Ex:100g): ")));
								n_metalico.setValorComercial(Double.parseDouble(l.entDados("\nValor Comecial(Ex:2.900 / Quilates): ")));
								flag2 = false;
							}
							catch(ComposicaoQGrdException cge){
								System.out.println("\ncatch de Formula Quimica -> Formula Quimica < 10");
							}
							catch(DurezaPqnException dpe){
								System.out.println("\ncatch de Dureza -> Dureza > 0");
							}
							catch(DurezaGrdException dge){
								System.out.println("\ncatch de Dureza -> Dureza <=10");
							}
							catch(NumberFormatException nfe){
								System.out.println("\ncatch Number -> Infomacao nao compativel.");
							}
						}
						n_metalico.setTransparencia(l.entDados("\nTransparencia(Ex:Semi-Transparente): "));
						n_metalico.setIsolamento(l.entDados("\nIsolamento(Ex: Moderado): "));
						System.out.println("\nInforma a origem do Mineral Nao Metalico:");
						n_metalico.getOrigem().setPais(l.entDados("\nPais(Ex:Brasil): "));
						n_metalico.getOrigem().setCidade(l.entDados("\nCidade(Ex:Araxa): "));
						n_metalico.getOrigem().setTipo_Extracao(l.entDados("\nTipo de Extracao(Ex:Mineracao a Ceu Aberto): "));
						System.out.println(n_metalico.Valor_para_Venda());
						System.out.println(n_metalico.GerarRelatorio());
					break;
					default:
					break;
				}

				flag3=Integer.parseInt(l.entDados("\nContinuar Cadastro:\n 0-Sim\n 1-Nao"));
		} while (flag3!=1);

	}
}
