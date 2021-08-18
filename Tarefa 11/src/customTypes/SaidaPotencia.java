package customTypes;

//import java.util.Arrays;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class SaidaPotencia {
	private double autovalor;
	private double[] autovetor;
	
	private NumberFormat form = new DecimalFormat("0.00000000");

	public SaidaPotencia(double autovalor, double[] autovetor) {
		this.autovalor = autovalor;
		this.autovetor = autovetor;
	}

	public double getAutovalor() {
		return this.autovalor;
	}

	public double[] getAutovetor() {
		return this.autovetor;
	}
	
	public void printData() {
		System.out.println("Autovalor: " + form.format(this.getAutovalor()));
		
		System.out.print("Autovetor: [");
		for (int i = 0; i < this.getAutovetor().length; i++) {
			System.out.print(form.format(this.getAutovetor()[i]));
			
			if (this.getAutovetor().length > i + 1) {
				System.out.print(", ");
			} else {
				System.out.println("]\n");
			}
		}
		
//		System.out.println("Autovetor: " + Arrays.toString(this.getAutovetor()) + "\n");
	}
}
