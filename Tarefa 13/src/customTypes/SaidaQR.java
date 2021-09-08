package customTypes;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class SaidaQR {
	private double[][] P;
	private double[] Lamb;
	
	private NumberFormat form = new DecimalFormat("0.00000000");
	
	public SaidaQR(double[][] P, double[] Lamb) {
		this.P = P;
		this.Lamb = Lamb;
	}
	
	public double[][] getP() {
		return this.P;
	}

	public double[] getLamb() {
		return this.Lamb;
	}
	
	public void printData() {
		System.out.print("Autovalores: [");
		for (int i = 0; i < this.getLamb().length; i++) {
			System.out.print(form.format(this.getLamb()[i]));
			
			if (this.getLamb().length > i + 1) {
				System.out.print(", ");
			} else {
				System.out.println("]\n");
			}
		}
		
		System.out.print("Autovetores:\n[");
		for (int i = 0; i < this.getP().length; i++) {
			System.out.print("[");
			for (int j = 0; j < this.getP()[i].length; j++) {
				System.out.print(form.format(this.getP()[i][j]));
				
				if (this.getP().length > j + 1) {
					System.out.print(", ");
				} else {
					System.out.print("]");
				}
			}
			
			if (this.getP().length > i + 1) {
				System.out.print(",\n");
			} else {
				System.out.println("]\n");
			}
		}
		
//		System.out.println("Autovetor: " + Arrays.toString(this.getAutovetor()) + "\n");
	}
}
