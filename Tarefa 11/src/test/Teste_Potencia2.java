package test;

import metodos.Metodos;

public class Teste_Potencia2 {

	public static void main(String[] args) {
		double[][] A1 = { { 5, 2, 1 }, { 2, 3, 1 }, { 1, 1, 2 } };
		double[] v01 = { 1, 1, 1 };
		double u1 = 2;

		System.out.println("-=-=-=-=Resultados A1:=-=-=-=-");
		
		System.out.println("Potência Regular:");
		new Metodos().potenciaRegular(A1, v01, 0.000001).printData();
		
		System.out.println("Potência Inversa:");
		new Metodos().potenciaInversa(A1, v01, 0.000001).printData();

		System.out.println("Potência com Deslocamento de " + u1 + ":");
		new Metodos().potenciaDeslocamento(A1, v01, 0.000001, u1).printData();
		
		double[][] A2 = { { -14, 1, -2 }, { 1, -1, 1 }, { -2, 1, -11 } };
		double[] v02 = { 1, 1, 1 };
		double u2 = -10;
		
		System.out.println("-=-=-=-=Resultados A2:=-=-=-=-");
		
		System.out.println("Potência Regular:");
		new Metodos().potenciaRegular(A2, v02, 0.000001).printData();
		
		System.out.println("Potência Inversa:");
		new Metodos().potenciaInversa(A2, v02, 0.000001).printData();

		System.out.println("Potência com Deslocamento de " + u2 + ":");
		new Metodos().potenciaDeslocamento(A2, v02, 0.000001, u2).printData();

		double[][] A3 = { { 40, 8, 4, 2, 1 }, { 8, 30, 12, 6, 2 }, { 4, 12, 20, 1, 2 }, { 2, 6, 1, 25, 4 },
				{ 1, 2, 2, 4, 5 } };
		double[] v03 = { 1, 1, 1, 1, 1 };
		double u3 = 10;

		System.out.println("-=-=-=-=Resultados A3:=-=-=-=-");
		
		System.out.println("Potência Regular:");
		new Metodos().potenciaRegular(A3, v03, 0.000001).printData();
		
		System.out.println("Potência Inversa:");
		new Metodos().potenciaInversa(A3, v03, 0.000001).printData();

		System.out.println("Potência com Deslocamento de " + u3 + ":");
		new Metodos().potenciaDeslocamento(A3, v03, 0.000001, u3).printData();

		System.out.println("Potência com Deslocamento de " + 20 + ":");
		new Metodos().potenciaDeslocamento(A3, v03, 0.000001, 20).printData();

		System.out.println("Potência com Deslocamento de " + 30 + ":");
		new Metodos().potenciaDeslocamento(A3, v03, 0.000001, 30).printData();
	}

}
