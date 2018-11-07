package construirImovel;

import java.util.ArrayList;
import java.util.HashMap;

public class Edificio extends Imovel {
	
	private int totalDeAndares;
	
	public Edificio(String cor, HashMap<Integer, ArrayList<Porta>> andar, int totalDePortas, int totalDeAndares) {
		super(cor, andar, totalDePortas);
		this.totalDeAndares = totalDeAndares;
	}
	
	public void setAndar(int i) {
		getAndar().put(i, new ArrayList<Porta>());
		this.totalDeAndares++;
	}

	public int quantasPortasEstaoAbertas() {
		int cont = 0;
		for (int i = 0; i < getAndar().size();i++) {
			for (int j = 0; j < getAndar().get(i).size(); j++ ) {
				if(getAndar().get(i).get(j).estaAberta()) {
					cont += 1;
				}
			}
		}
		 return cont;
	}

	public int totalDePortas() {
		return this.totalDePortas;
	}

	public int totalDeAndares() {
		return this.totalDeAndares;
	}
	
	public void removerAndar() {
		this.totalDeAndares--;
	}
}
