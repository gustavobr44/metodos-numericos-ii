package main;

import java.util.Arrays;

import metodos.MetodosPVC;

public class TestePVC {
	public static void main(String[] args) {
		// Problema de Valor de Contorno 1 da aula 27
		double[][] limitesPVC1 = { { 0, 0 }, { 1, 1 } };
		int N1 = 8;
		double[] mascaraPVC1 = { 1.0 / Math.pow(1.0 / N1, 2), -(2.0 / Math.pow(1.0 / N1, 2) + 1),
				1.0 / Math.pow(1.0 / N1, 2) };

		double[] resultadoPVC1 = MetodosPVC.applyUniPVCMask(limitesPVC1, N1, mascaraPVC1);

		System.out.println(Arrays.toString(resultadoPVC1));

		// Problema de Valor de Contorno 2 da aula 27
		double[][] limitesPVC2 = { { 0, 0 }, { 1, 0 }, { 0, 0 }, { 1, 0 } };
		int N2 = 8;
		double[][] mascaraPVC2 = {
				{0, 1.0 / Math.pow(1.0 / N2, 2), 0},
				{1.0 / Math.pow(1.0 / N2, 2), -2*(1.0 / Math.pow(1.0 / N2, 2) + 1.0 / Math.pow(1.0 / N2, 2)), 1.0 / Math.pow(1.0 / N2, 2)},
				{0, 1.0 / Math.pow(1.0 / N2, 2), 0}
		};
		double fxy = 4;
		
		double[] resultadoPVC2 = MetodosPVC.applyBiPVCMask(limitesPVC2, N2, mascaraPVC2, fxy);

		System.out.println(Arrays.toString(resultadoPVC2));
	}
}
