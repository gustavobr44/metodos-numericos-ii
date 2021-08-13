package customTypes;

public class SaidaPotReg {
	private double autovalor;
	private double[] autovetor;
	
	public SaidaPotReg(double autovalor, double[] autovetor) {
		this.autovalor = autovalor;
		this.autovetor = autovetor;
	}
	
	public double getAutovalor() {
		return this.autovalor;
	}
	
	public double[] getAutovetor() {
		return this.autovetor;
	}
}
