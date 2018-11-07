package construirImovel;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Imovel{
	
	protected String cor;
	protected int totalDePortas;
	protected HashMap<Integer, ArrayList<Porta>> andar;
	
	public Imovel(String cor, HashMap<Integer, ArrayList<Porta>> andar, int totalDePortas) {
		super();
		this.cor = cor;
		this.andar = new HashMap<Integer, ArrayList<Porta>>();
		this.totalDePortas = totalDePortas;
	}

	public void pintar(String cor) {
		this.cor = cor;
	}
	
	public String getCor() {
		return cor;
	}
	
	public HashMap<Integer, ArrayList<Porta>> getAndar() {
		return andar;
	}
	
	public void addPorta(int i, Porta p) {
		getAndar().get(i).add(p);
		this.totalDePortas++;
	}
	
	public void removerPorta(int i) {
		this.totalDePortas -= i;
	}
	
	abstract int quantasPortasEstaoAbertas();
	abstract int totalDePortas();
}
