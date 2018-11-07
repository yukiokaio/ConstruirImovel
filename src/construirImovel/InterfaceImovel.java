package construirImovel;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class InterfaceImovel {
	
	public void menuCasa() {
		
		Casa casa = new Casa("Cinza",null,0);
		casa.getAndar().put(0, new ArrayList<Porta>());
		
		String nP,cor,c,l,e;
		double comprimento,largura, espessura;
		boolean estado;
		int nPorta,est;
		
		while(true) {
			UIManager.put("OptionPane.okButtonText", "OK");
			UIManager.put("OptionPane.cancelButtonText", "Cancel");
			String opcao = JOptionPane.showInputDialog(null, "Digite a Funcionalidade Desejada: \n\n"  + "[0] Sair do Programa \n"  
													   + "[1] Alterar Cor da Casa\n" + "[2] Construir Porta (máx. 3) \n" 
													   + "[3] Alterar Atributos de uma Porta \n" 
													   + "[4] Exibir Quantas Portas estão Abertas \n" 
													   + "[5] Exibir Total de Portas \n" + "[6] Exibir os Atributos de uma Porta \n" 
													   + "[7] Remover Porta \n" + "[8] Criar Novo Imóvel \n\n", 
													   "Cor da Casa: " + casa.getCor(), 3);
			if (opcao == null || opcao.equals("8")) {
				break;
			}
			
			switch(opcao) {
			
				case "0":
					
					JOptionPane.showMessageDialog(null, "Volte Sempre!");
				    System.exit(0);
				    break;
					
				case "1":
					
					cor = JOptionPane.showInputDialog("Digite a Nova Cor da Casa: ");
					casa.pintar(cor);
					JOptionPane.showMessageDialog(null, "Cor da Casa Alterada com Sucesso!");
					break;
				    
				case "2":
					
					if (casa.totalDePortas() < 3) {
						Porta porta;
						UIManager.put("OptionPane.yesButtonText", "Porta Padrão");
						UIManager.put("OptionPane.noButtonText", "Porta Manual");
						int p = JOptionPane.showConfirmDialog(null, "Deseja usar Porta Padrão ou Construir Manualmente? ",
																	"Tipo de Porta", JOptionPane.YES_NO_OPTION);
						if (p == JOptionPane.YES_NO_OPTION ) {
							porta = new Porta(false, "Marrom", 90, 210, 3.5);
							casa.addPorta(0, porta);
							JOptionPane.showMessageDialog(null, "Porta Construída com Sucesso!");
						}
						else {
							UIManager.put("OptionPane.yesButtonText", "Aberta");
							UIManager.put("OptionPane.noButtonText", "Fechada");
							est = JOptionPane.showConfirmDialog(null, "Deseja a Porta Aberta ou Fechada? ",
																		"Estado da Porta", JOptionPane.YES_NO_OPTION);
							if (est == JOptionPane.YES_NO_OPTION ) {
								estado = true;
							}
							else {
								estado = false;
							}
							
							cor = JOptionPane.showInputDialog("Digite a Cor da Porta: ");
							
							l = JOptionPane.showInputDialog("Digite a Largura da Porta: ");
							
							if (l == null || l.isEmpty() || l.matches("[A-z]{1,}") || l.matches("[\\W]")) {
								largura = 90;
							}
							else {
								largura = Double.parseDouble(l);
							}
							
							c = JOptionPane.showInputDialog("Digite o Comprimento da Porta: ");
							
							if (c == null || c.isEmpty() || c.matches("[A-z]{1,}") || c.matches("[\\W]")) {
								comprimento = 210;
							}
							else {
								comprimento = Double.parseDouble(c);
							}
							
							e = JOptionPane.showInputDialog("Digite a Espessura da Porta: ");
							
							if (e == null || e.isEmpty() || e.matches("[A-z]{1,}") || e.matches("[\\W]")) {
								espessura = 3.5;
							}
							else {
								espessura = Double.parseDouble(e);
							}
							
							porta = new Porta(estado, cor, largura, comprimento, espessura);
							casa.addPorta(0, porta);
							JOptionPane.showMessageDialog(null, "Porta Construída com Sucesso!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Você Extrapolou o Máximo de Portas Permitidas! (Máx.3)", "Aviso!", 2);
					}	
					break;
					
				case "3":
					if (casa.totalDePortas() == 0) {
						JOptionPane.showMessageDialog(null, "Ainda Não Existem Portas Construídas no Edifício!", "Aviso!", 2);
						break;
					}
					else {
						String op = JOptionPane.showInputDialog(null, "Digite a Funcionalidade Desejada: \n\n" 
																+ "[0] Voltar Para o Menu Anterior \n" + "[1] Abrir ou Fechar uma Porta \n" 
																+ "[2] Alterar Cor de uma Porta \n" +"[3] Alterar Largura de uma Porta \n" 
																+ "[4] Alterar Comprimento de uma Porta \n" 
																+ "[5] Alterar Espessura de uma Porta \n\n",
																"Alterando Atributos de uma Porta:", 3);
						switch(op) {
						
							case "0":
								break;
								
							case "1":
								
								nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Abrir ou Fechar (Ordem de "
																+ "Construção):");
			
								if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								else {
									nPorta = Integer.parseInt(nP);
								}
								
								if (casa.totalDePortas() <= nPorta - 1 || nPorta < 1) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								
								if (casa.getAndar().get(0).get(nPorta - 1).estaAberta()) {
									UIManager.put("OptionPane.yesButtonText", "Deixar Aberta");
									UIManager.put("OptionPane.noButtonText", "Fechar");
									est = JOptionPane.showConfirmDialog(null, "Deseja a Porta Aberta ou Fechada? ",
																			"Estado da Porta: Aberta", JOptionPane.YES_NO_OPTION);
									if (est == JOptionPane.YES_NO_OPTION ) {
										casa.getAndar().get(0).get(nPorta - 1).abrir();
									}
									else {
										casa.getAndar().get(0).get(nPorta - 1).fechar();
									}
								}
								else {
									UIManager.put("OptionPane.yesButtonText", "Abrir");
									UIManager.put("OptionPane.noButtonText", "Deixar Fechada");
									est = JOptionPane.showConfirmDialog(null, "Deseja a Porta Aberta ou Fechada? ",
																			"Estado da Porta: Fechada", JOptionPane.YES_NO_OPTION);
									if (est == JOptionPane.YES_NO_OPTION ) {
										casa.getAndar().get(0).get(nPorta - 1).abrir();
									}
									else {
										casa.getAndar().get(0).get(nPorta - 1).fechar();
									}
								}
								JOptionPane.showMessageDialog(null, "Estado da Porta Mudado com Sucesso!");
								break;
							
							case "2":
	
								nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Alterar a Cor (Ordem de "
																+ "Construção):");
	
								if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								else {
									nPorta = Integer.parseInt(nP);
								}
								
								if (casa.totalDePortas() <= nPorta - 1 || nPorta < 1) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								
								cor = JOptionPane.showInputDialog("Digite a Nova Cor da Porta: ");
								casa.getAndar().get(0).get(nPorta - 1).pintar(cor);
								JOptionPane.showMessageDialog(null, "Cor da Porta Alterada com Sucesso!");
								
								break;
							
							case "3":
								
								nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Alterar a Largura (Ordem de "
																+ "Construção):");
	
								if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								else {
									nPorta = Integer.parseInt(nP);
								}
								
								if (casa.totalDePortas() <= nPorta - 1 || nPorta < 1) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								
								l = JOptionPane.showInputDialog("Digite a Nova Largura da Porta: ");
								
								if (l == null || l.isEmpty() || l.matches("[A-z]{1,}") || l.matches("[\\W]")) {
									JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar a Largura da Porta!", "Aviso!", 2);
									break;
								}
								else {
									largura = Double.parseDouble(l);
								}
								
								casa.getAndar().get(0).get(nPorta - 1).setDimensaoX(largura);
								JOptionPane.showMessageDialog(null, "Largura da Porta Alterada com Sucesso!");
								break;
							
							case "4":
								
								nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Alterar o Comprimento (Ordem de "
																+ "Construção):");
	
								if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								else {
									nPorta = Integer.parseInt(nP);
								}
								
								if (casa.totalDePortas() <= nPorta - 1 || nPorta < 1) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								
								c = JOptionPane.showInputDialog("Digite o Novo Comprimento da Porta: ");
								
								if (c == null || c.isEmpty() || c.matches("[A-z]{1,}") || c.matches("[\\W]")) {
									JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar o Comprimento da Porta!", "Aviso!", 2);
									break;
								}
								else {
									comprimento = Double.parseDouble(c);
								}
								
								casa.getAndar().get(0).get(nPorta - 1).setDimensaoY(comprimento);
								JOptionPane.showMessageDialog(null, "Comprimento da Porta Alterado com Sucesso!");
								break;
								
							case "5":
								
								nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Alterar a Espessura (Ordem de "
																+ "Construção):");
	
								if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								else {
									nPorta = Integer.parseInt(nP);
								}
								
								if (casa.totalDePortas() <= nPorta - 1 || nPorta < 1) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								
								e = JOptionPane.showInputDialog("Digite a Nova Espessura da Porta: ");
								
								if (e == null || e.isEmpty() || e.matches("[A-z]{1,}") || e.matches("[\\W]")) {
									JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar a Espessura da Porta!", "Aviso!", 2);
									break;
								}
								else {
									espessura = Double.parseDouble(e);
								}
								
								casa.getAndar().get(0).get(nPorta - 1).setDimensaoZ(espessura);
								JOptionPane.showMessageDialog(null, "Espessura da Porta Alterada com Sucesso!");
								break;
								
							default:
								JOptionPane.showMessageDialog(null, "O senhor(a) digitou uma opção inexistente! Tente novamente.", 
															"Aviso!", 2);
								break;
						}
					}
					break;
					
				case "4":
					
					if (casa.totalDePortas() == 0) {
						JOptionPane.showMessageDialog(null, "Ainda Não Existem Portas Construídas na Casa!", "Aviso!", 2);
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, "Estão Abertas na Casa: " + casa.quantasPortasEstaoAbertas() + " Portas!");
					}
					break;
					
				case "5":
					
					if (casa.totalDePortas() == 0) {
						JOptionPane.showMessageDialog(null, "Ainda Não Existem Portas Construídas na Casa!", "Aviso!", 2);
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, "Foram Construídas na Casa: " + casa.totalDePortas() + " Portas!");
					}
					break;
					
				case "6":
					
					if (casa.totalDePortas() == 0) {
						JOptionPane.showMessageDialog(null, "Ainda Não Existem Portas Construídas na Casa!", "Aviso!", 2);
						break;
					}
					else {
						nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Ver os Atributos:");
	
						if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
							JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
							break;
						}
						else {
							nPorta = Integer.parseInt(nP);
						}
						
						if (casa.totalDePortas() <= nPorta - 1 || nPorta < 1) {
							JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
							break;
						}
						
						String saida = "";
						
						for (int i = 0; i < casa.getAndar().get(0).size();i++) {
							if (i == nPorta - 1) {
								saida += ("Atributos da Porta: \n\n");
								if (casa.getAndar().get(0).get(i).estaAberta()) {
									saida += ("Estado da Porta: Aberta \n");
								}
								else {
									saida += ("Estado da Porta: Fechada \n");
								}
								saida += ("Cor: " + casa.getAndar().get(0).get(i).getCor() + "\n");
							    saida += ("Largura: " + casa.getAndar().get(0).get(i).getDimensaoX() + "\n");
								saida += ("Comprimento: " + casa.getAndar().get(0).get(i).getDimensaoY() + "\n");
								saida += ("Espessura: " + casa.getAndar().get(0).get(i).getDimensaoZ() + "\n" );
								break;
							}
						}
						JOptionPane.showMessageDialog(null,saida);
					}
					break;
					
				case "7":
					
					if (casa.totalDePortas() == 0) {
						JOptionPane.showMessageDialog(null, "Ainda Não Existem Portas Construídas na Casa!", "Aviso!", 2);
						break;
					}
					else {
						nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Remover (Ordem de Construção):");
						
						if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
							JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
							break;
						}
						else {
							nPorta = Integer.parseInt(nP);
						}
						
						if (casa.totalDePortas() <= nPorta - 1 || nPorta < 1) {
							JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
							break;
						}
						
						casa.getAndar().get(0).remove(nPorta - 1);
						casa.removerPorta(1);
						JOptionPane.showMessageDialog(null, "Porta Removida com Sucesso!");	
					}
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "O Senhor(a) Digitou uma Opção Inexistente! Tente Novamente.", "Aviso!", 2);
					break;		
			}
		}
	}
	
	public void menuEdificio() {
		
		Edificio edificio = new Edificio("Verde", null, 0, 0);
		edificio.setAndar(0);
		
		String nP,cor,c,l,e,a,s;
		double comprimento,largura, espessura;
		boolean estado;
		int nPorta,est,andar,cont;
		
		while(true) {
			UIManager.put("OptionPane.okButtonText", "OK");
			UIManager.put("OptionPane.cancelButtonText", "Cancel");
			String opcao = JOptionPane.showInputDialog(null, "Digite a Funcionalidade Desejada: \n\n" + "[0] Sair do Programa \n" 
													   + "[1] Alterar Cor do Edifício\n" + "[2] Construir Andares \n" 
													   + "[3] Construir Porta em um Andar \n"  
													   + "[4] Alterar Atributos de uma Porta em um Andar \n" 
													   + "[5] Exibir Quantas Portas estão Abertas \n"  
													   + "[6] Exibir Total de Portas \n" + "[7] Exibir os Atributos de uma Porta \n" 
													   + "[8] Exibir Quantidade de Andares \n" + "[9] Remover Porta ou Andar \n"
													   + "[10] Criar Novo Imóvel \n\n", "Cor do Edifício: " + edificio.getCor(), 3);
			if (opcao == null || opcao.equals("10")) {
				break;
			}
			
			switch(opcao) {
			
				case "0":
					
					JOptionPane.showMessageDialog(null, "Volte Sempre!");
					System.exit(0);
					break;
					
				case "1":
					
					cor = JOptionPane.showInputDialog("Digite a Nova Cor do Edíficio: ");
					edificio.pintar(cor);
					JOptionPane.showMessageDialog(null, "Cor do Edifício Alterada com Sucesso");
					break;
				
				case "2":
					a = JOptionPane.showInputDialog("Digite Quantos Andares Deseja Construir: ");
					
					if (a == null || a.isEmpty() || !a.matches("[0-9]{1,}")) {
						JOptionPane.showMessageDialog(null, "Não foi Possível Construir os Andares. Valor Incorreto!", "Aviso!", 2);
						break;
					}
					else {
						andar = Integer.parseInt(a);
					}
					
					for (int i = 0; i < andar; i++) {
						edificio.setAndar(edificio.totalDeAndares() - 1 + 1);
					}
					
					JOptionPane.showMessageDialog(null, "Andares Criados com Sucesso!");
					break;
					
				case "3":
					
					a = JOptionPane.showInputDialog("Digite o Andar que Deseja Construir a Porta: ");
					
					if (a == null || a.isEmpty() || !a.matches("[0-9]{1,}")) {
						JOptionPane.showMessageDialog(null, "Valor Incorreto!","Aviso!", 2);
						break;
					}
					else {
						andar = Integer.parseInt(a);
					}
					
					if (edificio.totalDeAndares() - 1 < andar) {
						JOptionPane.showMessageDialog(null, "O Andar não foi Construído!", "Aviso!", 2);
						break;
					}
					
					Porta porta;
					UIManager.put("OptionPane.yesButtonText", "Porta Padrão");
					UIManager.put("OptionPane.noButtonText", "Porta Manual");
					int p = JOptionPane.showConfirmDialog(null, "Deseja usar Porta Padrão ou Construir Manualmente? ",
																"Tipo de Porta", JOptionPane.YES_NO_OPTION);
					if (p == JOptionPane.YES_NO_OPTION ) {
						porta = new Porta(false, "Marrom", 90, 210, 3.5);
						edificio.addPorta(andar, porta);
						JOptionPane.showMessageDialog(null, "Porta Construída com Sucesso!");
					}
					else {
						UIManager.put("OptionPane.yesButtonText", "Aberta");
						UIManager.put("OptionPane.noButtonText", "Fechada");
						est = JOptionPane.showConfirmDialog(null, "Deseja a Porta Aberta ou Fechada? ",
																	"Estado da Porta", JOptionPane.YES_NO_OPTION);
						if (est == JOptionPane.YES_NO_OPTION ) {
							estado = true;
						}
						else {
							estado = false;
						}
						
						cor = JOptionPane.showInputDialog("Digite a Cor da Porta: ");
						
						l = JOptionPane.showInputDialog("Digite a Largura da Porta: ");
						
						if (l == null || l.isEmpty() || l.matches("[A-z]{1,}") || l.matches("[\\W]")) {
							largura = 90;
						}
						else {
							largura = Double.parseDouble(l);
						}
						
						c = JOptionPane.showInputDialog("Digite o Comprimento da Porta: ");
						
						if (c == null || c.isEmpty() || c.matches("[A-z]{1,}") || c.matches("[\\W]")) {
							comprimento = 210;
						}
						else {
							comprimento = Double.parseDouble(c);
						}
						
						e = JOptionPane.showInputDialog("Digite a Espessura da Porta: ");
						
						if (e == null || e.isEmpty() || e.matches("[A-z]{1,}") || e.matches("[\\W]")) {
							espessura = 3.5;
						}
						else {
							espessura = Double.parseDouble(e);
						}
						
						porta = new Porta(estado, cor, largura, comprimento, espessura);
						edificio.addPorta(andar, porta);
						JOptionPane.showMessageDialog(null, "Porta Construída com Sucesso!");
					}
					
					break;
					
				case "4":
					
					if (edificio.totalDePortas() == 0) {
						JOptionPane.showMessageDialog(null, "Ainda Não Existem Portas Construídas no Edifício!", "Aviso!", 2);
						break;
					}
					else {
						String op = JOptionPane.showInputDialog(null,"Digite a Funcionalidade Desejada: \n\n" 
																+ "[0] Voltar Para o Menu Anterior \n" + "[1] Abrir ou Fechar uma Porta \n" 
																+ "[2] Alterar Cor de uma Porta \n" +"[3] Alterar Largura de uma Porta \n" 
																+ "[4] Alterar Comprimento de uma Porta \n" 
																+ "[5] Alterar Espessura de uma Porta \n\n", "Atributos de uma Porta:", 3);
						
						switch(op) {
							
							case "0":
								break;
						
							case "1":
								a = JOptionPane.showInputDialog("Digite o Andar que Deseja Abrir ou Fechar a Porta: ");
								
								if (a == null || a.isEmpty() || !a.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Valor Incorreto!", "Aviso!", 2);
									break;
								}
								else {
									andar = Integer.parseInt(a);
								}
								
								if (edificio.totalDeAndares() - 1 < andar) {
									JOptionPane.showMessageDialog(null, "O Andar não foi Construído!", "Aviso!", 2);
									break;
								}
								
								nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Abrir ou Fechar (Ordem de "
																+ "Construção no Andar): ");
			
								if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								else {
									nPorta = Integer.parseInt(nP);
								}
								if (edificio.getAndar().get(andar).size() <= nPorta - 1 || nPorta < 1) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								
								if (edificio.getAndar().get(andar).get(nPorta - 1).estaAberta()) {
									UIManager.put("OptionPane.yesButtonText", "Deixar Aberta");
									UIManager.put("OptionPane.noButtonText", "Fechar");
									est = JOptionPane.showConfirmDialog(null, "Deseja a Porta Aberta ou Fechada? ",
																			"Estado da Porta: Aberta", JOptionPane.YES_NO_OPTION);
									if (est == JOptionPane.YES_NO_OPTION ) {
										edificio.getAndar().get(andar).get(nPorta - 1).abrir();
									}
									else {
										edificio.getAndar().get(andar).get(nPorta - 1).fechar();
									}
								}
								else {
									UIManager.put("OptionPane.yesButtonText", "Abrir");
									UIManager.put("OptionPane.noButtonText", "Deixar Fechada");
									est = JOptionPane.showConfirmDialog(null, "Deseja a Porta Aberta ou Fechada? ",
																			"Estado da Porta: Fechada", JOptionPane.YES_NO_OPTION);
									if (est == JOptionPane.YES_NO_OPTION ) {
										edificio.getAndar().get(andar).get(nPorta - 1).abrir();
									}
									else {
										edificio.getAndar().get(andar).get(nPorta - 1).fechar();
									}
								}
								JOptionPane.showMessageDialog(null, "Estado da Porta Mudado com Sucesso!");
								break;
							
							case "2":
								
								a = JOptionPane.showInputDialog("Digite o Andar que Deseja Alterar a Cor da Porta: ");
								
								if( a == null || a.isEmpty() || !a.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Valor Incorreto!", "Aviso!", 2);
									break;
								}
								else {
									andar = Integer.parseInt(a);
								}
								
								if (edificio.totalDeAndares() - 1 < andar) {
									JOptionPane.showMessageDialog(null, "O Andar não foi Construído!", "Aviso!", 2);
									break;
								}
	
								nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Alterar a Cor (Ordem de "
																+ "Construção no Andar):");
	
								if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								else {
									nPorta = Integer.parseInt(nP);
								}
								
								if (edificio.getAndar().get(andar).size() <= nPorta - 1 || nPorta < 1) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								
								cor = JOptionPane.showInputDialog("Digite a Nova Cor da Porta: ");
								edificio.getAndar().get(andar).get(nPorta - 1).pintar(cor);
								JOptionPane.showMessageDialog(null, "Cor da Porta Alterada com Sucesso!");
								
								break;
							
							case "3":
								
								a = JOptionPane.showInputDialog("Digite o Andar que Deseja Alterar a Largura de uma Porta: ");
								
								if (a == null || a.isEmpty() || !a.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Valor Incorreto!", "Aviso!", 2);
									break;
								}
								else {
									andar = Integer.parseInt(a);
								}
								
								if (edificio.totalDeAndares() - 1 < andar) {
									JOptionPane.showMessageDialog(null, "O Andar não foi Construído!", "Aviso!", 2);
									break;
								}
								
								nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Alterar a Largura (Ordem de "
																+ "Construção no Andar):");
	
								if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								else {
									nPorta = Integer.parseInt(nP);
								}
								
								if (edificio.getAndar().get(andar).size() <= nPorta - 1 || nPorta < 1) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								
								l = JOptionPane.showInputDialog("Digite a Nova Largura da Porta: ");
								
								if (l == null || l.isEmpty() || l.matches("[A-z]{1,}") || l.matches("[\\W]")) {
									JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar a Largura da Porta!", "Aviso!", 2);
									break;
								}
								else {
									largura = Double.parseDouble(l);
								}
								
								edificio.getAndar().get(andar).get(nPorta - 1).setDimensaoX(largura);
								JOptionPane.showMessageDialog(null, "Largura da Porta Alterada com Sucesso!");
								break;
							
							case "4":
								
								a = JOptionPane.showInputDialog("Digite o Andar que Deseja Alterar o Comprimento de uma Porta: ");
								
								if (a == null || a.isEmpty() || !a.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Valor Incorreto!", "Aviso!", 2);
									break;
								}
								else {
									andar = Integer.parseInt(a);
								}
								
								if (edificio.totalDeAndares() - 1 < andar) {
									JOptionPane.showMessageDialog(null, "O Andar não foi Construído!", "Aviso!", 2);
									break;
								}
								
								nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Alterar o Comprimento (Ordem de "
																+ "Construção no Andar):");
	
								if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								else {
									nPorta = Integer.parseInt(nP);
								}
								
								if (edificio.getAndar().get(andar).size() <= nPorta - 1 || nPorta < 1) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!","Aviso!", 2);
									break;
								}
								
								c = JOptionPane.showInputDialog("Digite o Novo Comprimento da Porta: ");
								
								if (c == null || c.isEmpty() || c.matches("[A-z]{1,}") || c.matches("[\\W]")) {
									JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar o Comprimento da Porta!", "Aviso!", 2);
									break;
								}
								else {
									comprimento = Double.parseDouble(c);
								}
								
								edificio.getAndar().get(andar).get(nPorta - 1).setDimensaoY(comprimento);
								JOptionPane.showMessageDialog(null, "Comprimento da Porta Alterado com Sucesso!");
								break;
								
							case "5":
								
								a = JOptionPane.showInputDialog("Digite o Andar que Deseja Alterar a Espessura de uma Porta: ");
								
								if(a == null || a.isEmpty() || !a.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Valor Incorreto!","Aviso!", 2);
									break;
								}
								else {
									andar = Integer.parseInt(a);
								}
								
								if (edificio.totalDeAndares() - 1 < andar) {
									JOptionPane.showMessageDialog(null, "O Andar não foi Construído!", "Aviso!", 2);
									break;
								}
								
								nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Alterar a Espessura (Ordem de "
																+ "Construção no Andar):");
	
								if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								else {
									nPorta = Integer.parseInt(nP);
								}
								
								if (edificio.getAndar().get(andar).size() <= nPorta - 1 || nPorta < 1) {
									JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
									break;
								}
								
								e = JOptionPane.showInputDialog("Digite a Nova Espessura da Porta: ");
								
								if (e == null || e.isEmpty() || e.matches("[A-z]{1,}")|| e.matches("[\\W]")) {
									JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar a Espessura da Porta!", "Aviso!", 2);
									break;
								}
								else {
									espessura = Double.parseDouble(e);
								}
								
								edificio.getAndar().get(andar).get(nPorta - 1).setDimensaoZ(espessura);
								JOptionPane.showMessageDialog(null, "Espessura da Porta Alterada com Sucesso!");
								break;
								
							default:
								JOptionPane.showMessageDialog(null, "O Senhor(a) Digitou uma Opção Inexistente! Tente Novamente.", 
																"Aviso!", 2);
								break;
						}
					}
					break;
					
				case "5":

					if (edificio.totalDePortas() == 0) {
						JOptionPane.showMessageDialog(null, "Ainda Não Existem Portas Construídas no Edifício!", "Aviso!", 2);
						break;
					}
					else {
						s = "";
						cont = 0;
						s += ("Lista de Portas Abertas: \n\n");
						for (int i = 0; i < edificio.getAndar().size();i++) {
							for (int j = 0; j < edificio.getAndar().get(i).size(); j++ ) {
								if (edificio.getAndar().get(i).get(j).estaAberta()) {
									cont += 1;
								}
							}
							if (i == 0) {
								s += ("Estão Abertas no Térreo: " + cont + " Portas! \n");
							}
							else {
								s += ("Estão Abertas no " + i + "º Andar: " + cont + " Portas! \n");
							}
							cont = 0;
						}
						s += ("\nEstão Abertas no Total: " + edificio.quantasPortasEstaoAbertas() + " Portas!");
						JOptionPane.showMessageDialog(null, s);
					}
					break;
				
				case "6":
					
					if (edificio.totalDePortas() == 0) {
						JOptionPane.showMessageDialog(null, "Ainda Não Existem Portas Construídas no Edifício!", "Aviso!", 2);
						break;
					}
					else {
						s = "";
						cont = 0;
						s += ("Lista de Portas nos Andares: \n\n");
						for (int i = 0; i < edificio.getAndar().size();i++) {
								cont = edificio.getAndar().get(i).size();
								if (i == 0) {
									s += ("Existem no Térreo: " + cont + " Portas! \n");
								}
								else {
									s += ("Existem no " + i + "º Andar: " + cont + " Portas! \n");
								}
								cont = 0;
							}
						
						s += ("\nExistem no Edifício: " + edificio.totalDePortas() + " Portas!");
						JOptionPane.showMessageDialog(null, s);
					}
					break;
					
				case "7":
					
					if (edificio.totalDePortas() == 0) {
						JOptionPane.showMessageDialog(null, "Ainda Não Existem Portas Construídas no Edifício!", "Aviso!", 2);
						break;
					}
					else {
						
						a = JOptionPane.showInputDialog("Digite o Andar que Deseja Listar os Atributos de uma Porta: ");
						
						if (a == null || a.isEmpty() || !a.matches("[0-9]{1,}")) {
							JOptionPane.showMessageDialog(null, "Valor Incorreto!", "Aviso!", 2);
							break;
						}
						else {
							andar = Integer.parseInt(a);
						}
						
						if (edificio.totalDeAndares() - 1 < andar) {
							JOptionPane.showMessageDialog(null, "O Andar não foi Construído!", "Aviso!", 2);
							break;
						}
	
						nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Listar os Atributos (Ordem de "
															+ "Construção no Andar):");
	
						if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
							JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
							break;
						}
						else {
							nPorta = Integer.parseInt(nP);
						}
						
						if (edificio.getAndar().get(andar).size() <= nPorta - 1 || nPorta < 1) {
							JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
							break;
						}	
						s = "";
						
						for (int i = 0; i < edificio.getAndar().get(andar).size();i++) {
							if (i == nPorta - 1) {
								s += ("Atributos da Porta: \n\n");
								if (edificio.getAndar().get(andar).get(i).estaAberta()) {
									s += ("Estado da Porta: Aberta \n");
								}
								else {
									s += ("Estado da Porta: Fechada \n");
								}
								s += ("Cor: " + edificio.getAndar().get(andar).get(i).getCor() + "\n");
							    s += ("Largura: " + edificio.getAndar().get(andar).get(i).getDimensaoX() + "\n");
								s += ("Comprimento: " + edificio.getAndar().get(andar).get(i).getDimensaoY() + "\n");
								s += ("Espessura: " + edificio.getAndar().get(andar).get(i).getDimensaoZ() + "\n" );
								break;
							}
						}
						JOptionPane.showMessageDialog(null, s);
					}
					break;
					
				case "8":
					
					if (edificio.totalDeAndares() == 1) {
						JOptionPane.showMessageDialog(null, "O Edifício tem somente o Térreo!");
					}
					else {
						andar = edificio.totalDeAndares() - 1;
						JOptionPane.showMessageDialog(null, "O Edifício tem o Térreo e " + andar + " Andares!");
					}	
					break;
					
				case "9":
					
					UIManager.put("OptionPane.yesButtonText", "Andar");
					UIManager.put("OptionPane.noButtonText", "Porta");
					est = JOptionPane.showConfirmDialog(null, "Deseja Remover um Andar ou uma Porta? ",
														  "Remoção de Andares e Portas", JOptionPane.YES_NO_OPTION);
					
					if (est == JOptionPane.YES_NO_OPTION ) {
						JOptionPane.showMessageDialog(null, "Atenção! Também serão Removidos Todos os Andares acima do Andar a ser "
														+ "Removido!", "Aviso!", 2);
						a = JOptionPane.showInputDialog("Digite o Andar que Deseja Remover: ");
						
						if (a == null || a.isEmpty() || !a.matches("[0-9]{1,}")) {
							JOptionPane.showMessageDialog(null, "Valor Incorreto!", "Aviso!", 2);
							break;
						}
						else {
							andar = Integer.parseInt(a);
						}
						
						if (edificio.totalDeAndares() - 1 < andar) {
							JOptionPane.showMessageDialog(null, "O Andar não foi Construído!", "Aviso!", 2);
							break;
						}
						else if(andar == 0) {
							JOptionPane.showMessageDialog(null, "Não é Possível Remover o Térreo!", "Aviso!", 2);
							break;
						}
						int total = edificio.totalDeAndares() - andar ;
						cont = 0;
						for (int i = 0; i < total; i++) {
							cont += edificio.getAndar().get(edificio.totalDeAndares() - 1).size();
							edificio.getAndar().remove(edificio.totalDeAndares() - 1);
							edificio.removerAndar();
						}
						edificio.removerPorta(cont);
						JOptionPane.showMessageDialog(null, "O Andar foi Removido com Sucesso!");
						
					}
					else {
						if (edificio.totalDePortas() == 0) {
							JOptionPane.showMessageDialog(null, "Ainda Não Existem Portas Construídas no Edifício!", "Aviso!", 2);
							break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Atenção! Remover uma Porta faz as Portas Depois dela Diminuírem em -1 "
														  + "seus Números na Ordem de Criação!", "Aviso!", 2);
							a = JOptionPane.showInputDialog("Digite o Andar da Porta a ser Removida: ");
							
							if (a == null || a.isEmpty() || !a.matches("[0-9]{1,}")) {
								JOptionPane.showMessageDialog(null, "Valor Incorreto!", "Aviso!", 2);
								break;
							}
							else {
								andar = Integer.parseInt(a);
							}
							
							if (edificio.totalDeAndares() - 1 < andar) {
								JOptionPane.showMessageDialog(null, "O Andar não foi Construído!", "Aviso!", 2);
								break;
							}
		
							nP = JOptionPane.showInputDialog("Digite o Número da Porta que Deseja Remover (Ordem de Construção no Andar):");
		
							if (nP == null || nP.isEmpty() || !nP.matches("[0-9]{1,}")) {
								JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
								break;
							}
							else {
								nPorta = Integer.parseInt(nP);
							}
							
							if (edificio.getAndar().get(andar).size() <= nPorta - 1 || nPorta < 1) {
								JOptionPane.showMessageDialog(null, "Porta não Construída!", "Aviso!", 2);
								break;
							}
							
							edificio.getAndar().get(andar).remove(nPorta - 1);
							edificio.removerPorta(1);
							JOptionPane.showMessageDialog(null, "A Porta foi Removida com Sucesso!");
						}
					}
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "O Senhor(a) Digitou uma Opção Inexistente! Tente Novamente.", "Aviso!", 2);
					break;
			}
		}
	}
}