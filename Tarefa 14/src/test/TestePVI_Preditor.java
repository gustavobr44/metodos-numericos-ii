package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import lambdaFunctions.DoubleArrayFunction;
import pviMethods.PVIMethods;

public class TestePVI_Preditor {

	public static void main(String[] args) {
		// Definição do Problema de Valor Inicial 2 da aula 25
		double t0 = 0, dt = 0.1, tatual = t0;
		double v0 = 5, y0 = 200;
		double k = 0.25, m = 2, g = 10;

		ArrayList<double[]> S = new ArrayList<double[]>();
		double[] S0 = { v0, y0 };
		S.add(S0);

		DoubleArrayFunction F = (Si) -> {
			double[] Sn = { -g - (k / m) * Si[0], Si[0] };
			return Sn;
		};

		try {
			File save = new File("dados.csv");
			save.createNewFile();

			FileWriter saver = new FileWriter("dados.csv");

			saver.append("t,v,y\n");
			saver.append(t0 + "," + S0[0] + "," + S0[1] + "\n");

			double ymax = S0[1], tmax = 0, ttotal = 0, vultimo = S0[0];
			double v10 = 0, y10 = 0;

			// For para descobrir quando y = 0
			for (double i = 1; S0[1] > 0; i++) {
				int n = (S.size() < 4) ? S.size() : 4; // Garantia de que só irá passar os 4 últimos elementos ou menos
				double[][] Sik = new double[n][S0.length];
				
				for (int j = 0; j < n; j++) {
					Sik[j] = S.get(S.size() - (n - j));
				}

				S0 = PVIMethods.preditorCorretor4(Sik, F, dt); // Aplicação do método Preditor-Corretor
				S.add(S0);

				tatual = i * dt + t0;

				saver.append(tatual + "," + S0[0] + "," + S0[1] + "\n");

				if (S0[1] > ymax) {
					ymax = S0[1];
					tmax = i * dt;
				}

				if (S0[1] <= 0) {
					ttotal = i * dt;
					vultimo = S0[0];
				}
			}

			S.clear();
			S0[0] = v0;
			S0[1] = y0;
			S.add(S0);

			// For para descobrir resultados quando t = 10
			for (double i = 1; tatual < 10; i++) {
				int n = (S.size() < 4) ? S.size() : 4;
				double[][] Sik = new double[n][S0.length];
				
				for (int j = 0; j < n; j++) {
					Sik[j] = S.get(S.size() - (n - j));
				}
				
				S0 = PVIMethods.preditorCorretor4(Sik, F, dt);
				S.add(S0);

				tatual = i * dt + t0;

				if ((int) tatual == 10) {
					v10 = S0[0];
					y10 = S0[1];
				}
			}

			System.out.println("v10: " + v10);
			System.out.println("y10: " + y10 + "\n");

			System.out.println("ymax: " + ymax);
			System.out.println("tmax: " + tmax);
			System.out.println("ttotal: " + ttotal);
			System.out.println("vultimo: " + vultimo);

			saver.close();

			Runtime.getRuntime().exec("py makeGraphs.py");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
