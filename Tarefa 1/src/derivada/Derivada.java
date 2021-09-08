package derivada;

import lambdaFunctions.DoubleFunction;

public class Derivada {
	static public double derivadaSegundaIterativo(DoubleFunction f, double x, double e) {
		double df2n = 0.0, df2v = df2n;
		double dx = 1;
		double ex;

		do {
			df2v = df2n;
			dx = dx / 2.0;

			df2n = (1 / Math.pow(dx, 2)) * ((1 / 90) * f.funcao(x - 3 * dx) - (3 / 20) * f.funcao(x - 2 * dx)
					+ (3 / 2) * f.funcao(x - dx) - (49 / 18) * f.funcao(x) + (3 / 2) * f.funcao(x + dx)
					- (3 / 20) * f.funcao(x + 2 * dx) + (1 / 90) * f.funcao(x + 3 * dx));

			ex = Math.abs((df2n - df2v) / df2n);
		} while (ex > e);

		return df2n;
	}

	static public double derivadaSegunda(DoubleFunction f, double x, double dx) {
		double df2 = (1 / Math.pow(dx, 2)) * ((1 / 90) * f.funcao(x - 3 * dx) - (3 / 20) * f.funcao(x - 2 * dx)
				+ (3 / 2) * f.funcao(x - dx) - (49 / 18) * f.funcao(x) + (3 / 2) * f.funcao(x + dx)
				- (3 / 20) * f.funcao(x + 2 * dx) + (1 / 90) * f.funcao(x + 3 * dx));

		return df2;
	}
}
