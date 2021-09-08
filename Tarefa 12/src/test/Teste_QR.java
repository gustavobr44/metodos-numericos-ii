package test;

import metodos.Metodos;

public class Teste_QR {

	public static void main(String[] args) {
//		double[][] A = { { 40, 8, 4, 2, 1 }, { 8, 30, 12, 6, 2 }, { 4, 12, 20, 1, 2 }, { 2, 6, 1, 25, 4 },
//				{ 1, 2, 2, 4, 5 } };
//		int n = A.length;
//		double e = 0.000001;
		
		double[][] A = {{30, 10, 40, 30, 50}, {10, 12, 8, 30, 40}, {40, 8, 50, 20, 7}, {30, 30, 20, 40, 5}, {50, 40, 7, 5, 60}};
		int n = A.length;
		double e = 0.000001;

		System.out.println("-=-=-=-=Resultado A:=-=-=-=-");
		
		System.out.println("Método QR:");
		new Metodos().metodoQR(A, n, e).printData(); // Cada coluna da matriz de utovetores é um autovetor
	}

}
