import metodos.*;

import java.util.Arrays;

import customTypes.*;

public class Teste {
	public static void main(String[] args) {
//		double[] A = {1, 2, 3};
		
//		System.out.println((new MatrixMethods()).vectorModule(A));
		
		double[][] A1 = {{ 5, 2, 1 }, { 2, 3, 1 }, { 1, 1, 2}};
		double[] v01 = {1, 1, 1};
		
		SaidaPotReg result1 = (new Metodos()).potenciaRegular(A1, v01, 0.000001);
		
		System.out.println(result1.getAutovalor());
		System.out.println(Arrays.toString(result1.getAutovetor()));
		
		double[][] A2 = {{ 40, 8, 4, 2, 1 }, { 8, 30, 12, 6, 2 }, { 4, 12, 20, 1, 2}, { 2, 6, 1, 25, 4 }, { 1, 2, 2, 4, 5 }};
		double[] v02 = {1, 1, 1, 1, 1};
		
		SaidaPotReg result2 = (new Metodos()).potenciaRegular(A2, v02, 0.000001);
		
		System.out.println(result2.getAutovalor());
		System.out.println(Arrays.toString(result2.getAutovetor()));
	}
}
