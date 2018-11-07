package construirImovel;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ConstruirImovel {
	
	public static void main(String[] args) {
		InterfaceImovel imovel = new InterfaceImovel();
		
		while(true) {
			UIManager.put("OptionPane.yesButtonText", "Casa");
			UIManager.put("OptionPane.noButtonText", "Edifício");
			UIManager.put("OptionPane.cancelButtonText", "Sair");
			int p = JOptionPane.showConfirmDialog(null, "Qual Imóvel Deseja Construir? ",
												  "Tipo de Imóvel", JOptionPane.YES_NO_CANCEL_OPTION);
			
			String s = Integer.toString(p);
			
			if (s.equals("0")) {
				imovel.menuCasa();
			}
			else if (s.equals("1")){
				imovel.menuEdificio();
			}
			else {
				JOptionPane.showMessageDialog(null, "Volte Sempre!");
				System.exit(0);
				break;
			}
			
		}
		
	}
}
