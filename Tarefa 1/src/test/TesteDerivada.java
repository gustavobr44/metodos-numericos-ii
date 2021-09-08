package test;

import derivada.Derivada;
import lambdaFunctions.DoubleFunction;

public class TesteDerivada {

	public static void main(String[] args) {
		double x = 4.3, dx = 0.001;
		
//		DoubleFunction f = (xi) -> Math.sqrt(Math.pow(Math.E, 3*xi) + 4 * Math.pow(xi, 2));
		DoubleFunction f = (xi) -> Math.log(2*xi) * Math.cos(4*xi);
		
		double df2 = Derivada.derivadaSegunda(f, x, dx);
		
		System.out.println(df2);
	}

}
