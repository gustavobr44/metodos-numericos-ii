package pviMethods;

import lambdaFunctions.DoubleArrayFunction;

public class PVIMethods {
	static public double[] rungeKutta3(double[] Si, DoubleArrayFunction F, double dt) {
		int n = Si.length;

		double[] F1 = new double[n], S1 = new double[n];
		double[] F2 = new double[n], S2 = new double[n];
		double[] F3 = new double[n], Sf = new double[n];

		F1 = F.funcao(Si);
		for (int i = 0; i < n; i++)
			S1[i] = Si[i] + (dt / 2) * F1[i];

		F2 = F.funcao(S1);
		for (int i = 0; i < n; i++)
			S2[i] = Si[i] + dt * (-F1[i] + 2 * F2[i]);

		F3 = F.funcao(S2);
		for (int i = 0; i < n; i++)
			Sf[i] = Si[i] + dt * ((1.0 / 6) * F1[i] + (4.0 / 6) * F2[i] + (1.0 / 6) * F3[i]);

		return Sf;
	}

	static public double[] rungeKutta4(double[] Si, DoubleArrayFunction F, double dt) {
		int n = Si.length;

		double[] F1 = new double[n], S2 = new double[n];
		double[] F2 = new double[n], S3 = new double[n];
		double[] F3 = new double[n], S4 = new double[n];
		double[] F4 = new double[n], Sf = new double[n];

		F1 = F.funcao(Si);
		for (int i = 0; i < n; i++)
			S2[i] = Si[i] + (dt / 2) * F1[i];

		F2 = F.funcao(S2);
		for (int i = 0; i < n; i++)
			S3[i] = Si[i] + (dt / 2) * F2[i];

		F3 = F.funcao(S3);
		for (int i = 0; i < n; i++)
			S4[i] = Si[i] + dt * F3[i];

		F4 = F.funcao(S4);
		for (int i = 0; i < n; i++)
			Sf[i] = Si[i] + (dt / 6) * (F1[i] + 2 * F2[i] + 2 * F3[i] + F4[i]);

		return Sf;
	}

	static public double[] preditorCorretor4(double[][] Sik, DoubleArrayFunction F, double dt) {
		int k = Sik.length;
		int n = Sik[0].length;

		if (k < 4) {
			return rungeKutta4(Sik[k - 1], F, dt);
		}

		double[] Si1_ = new double[n];

		double[] Fi = F.funcao(Sik[k - 1]);
		double[] Fi1 = F.funcao(Sik[k - 2]);
		double[] Fi2 = F.funcao(Sik[k - 3]);
		double[] Fi3 = F.funcao(Sik[k - 4]);

		for (int i = 0; i < n; i++) {
			Si1_[i] = Sik[k - 1][i] + (dt / 24) * (-9 * Fi3[i] + 37 * Fi2[i] - 59 * Fi1[i] + 55 * Fi[i]);
		}
		
		double[] Si1 = new double[n];
		
		double[] Fn = F.funcao(Si1_);
		
		for (int i = 0; i < n; i++) {
			Si1[i] = Sik[k - 1][i] + (dt / 24) * (Fi2[i] - 5 * Fi1[i] + 19 * Fi[i] + 9 * Fn[i]);
		}

		return Si1;
	}
}
