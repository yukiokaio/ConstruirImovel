package construirImovel;

import java.util.ArrayList;
import java.util.HashMap;

public class Casa extends Imovel {
	
	public Casa(String cor, HashMap<Integer, ArrayList<Porta>> andar, int totalDePortas) {
		super(cor, andar, totalDePortas);
	}
	
	public int quantasPortasEstaoAbertas() {
		int cont = 0;
		for (int i = 0; i < getAndar().get(0).size();i++) {
			if(getAndar().get(0).get(i).estaAberta()) {
				cont += 1;
			}
		}
		 return cont;
	}
	
	public int totalDePortas() {
		return this.totalDePortas;
	}
}