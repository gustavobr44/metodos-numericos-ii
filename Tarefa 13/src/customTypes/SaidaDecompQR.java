package customTypes;

public class SaidaDecompQR {
	private double[][] Q, R;

	public SaidaDecompQR(double[][] Q, double[][] R) {
		this.Q = Q;
		this.R = R;
	}
	
	public double[][] getQ() {
		return this.Q;
	}

	public double[][] getR() {
		return this.R;
	}

}
