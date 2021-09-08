package pviMethods;

import lambdaFunctions.DoubleFunction;
import lambdaFunctions.DoubleArrayFunction;

public class PVIMethods {
	static public double[] rungeKutta3_PVI2(double[] Si, DoubleFunction[] F, double dt) {
		double[] F1 = new double[F.length], Si1 = new double[Si.length];
		double[] F2 = new double[F.length], Si2 = new double[Si.length];
		double[] F3 = new double[F.length], Sf = new double[Si.length];

		for (int i = 0; i < F.length; i++) {
			F1[i] = F[i].funcao(Si[0]);
			Si1[i] = Si[i] + (dt / 2) * F1[i];

			F2[i] = F[i].funcao(Si1[0]);
			Si2[i] = Si[i] + dt * (-F1[i] + 2 * F2[i]);

			F3[i] = F[i].funcao(Si2[0]);
			Sf[i] = Si[i] + dt * ((1.0 / 6) * F1[i] + (4.0 / 6) * F2[i] + (1.0 / 6) * F3[i]);
		}

		return Sf;
	}

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
}
