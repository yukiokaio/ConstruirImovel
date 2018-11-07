package construirImovel;

public class Porta{
	
	private String cor;
	private boolean aberta;
	private double dimensaoX, dimensaoY, dimensaoZ;
	
	public Porta(boolean aberta, String cor, double dimensaoX, double dimensaoY, double dimensaoZ) {
		this.aberta = aberta;
		this.cor = cor;
		this.dimensaoX = dimensaoX;
		this.dimensaoY = dimensaoY;
		this.dimensaoZ = dimensaoZ;
	}
	
	public void abrir() {
		this.aberta = true;
	}
	
	public void fechar() {
		this.aberta = false;
	}
	
	public boolean estaAberta() {
		return aberta;
	}
	
	public void pintar(String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public double getDimensaoX() {
		return dimensaoX;
	}

	public void setDimensaoX(double dimensaoX) {
		this.dimensaoX = dimensaoX;
	}

	public double getDimensaoY() {
		return dimensaoY;
	}

	public void setDimensaoY(double dimensaoY) {
		this.dimensaoY = dimensaoY;
	}

	public double getDimensaoZ() {
		return dimensaoZ;
	}

	public void setDimensaoZ(double dimensaoZ) {
		this.dimensaoZ = dimensaoZ;
	}
}