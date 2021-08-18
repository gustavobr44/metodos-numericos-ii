package metodos;

import customTypes.*;
import matrixManipulation.*;

public class Metodos {
	private MatrixOperations mOP = new MatrixOperations();
	private MatrixMethods mME = new MatrixMethods();

	public SaidaPotencia potenciaRegular(double[][] A, double[] v0, double e) {
		double lamb1n = 0, lamb1v = lamb1n;
		double[] vkn = v0, vkv = vkn;
		double[] x1v = null;

		do {
			lamb1v = lamb1n;
			vkv = vkn;

			x1v = new double[vkv.length];
			double mod = mOP.vectorModule(vkv);

			for (int i = 0; i < vkv.length; i++) {
				x1v[i] = vkv[i] / mod;
			}

			vkn = mOP.matrixTranspose(mOP.matrixMultiply(A, mOP.vectorToMatrix(x1v)))[0];

			lamb1n = mOP.vectorMultiply(x1v, vkn);
		} while (Math.abs((lamb1n - lamb1v) / lamb1n) > e);

		return new SaidaPotencia(lamb1n, x1v);
	}

	public SaidaPotencia potenciaInversa(double[][] A, double[] v0, double e) {
		double lambt1n = 0, lambt1v = lambt1n;
		double[] vkn = v0, vkv = vkn;
		double[] x1v = null;

		do {
			lambt1v = lambt1n;
			vkv = vkn;

			x1v = new double[vkv.length];
			double mod = mOP.vectorModule(vkv);

			for (int i = 0; i < vkv.length; i++) {
				x1v[i] = vkv[i] / mod;
			}

			vkn = mME.LUfactorization(A, x1v);

			lambt1n = mOP.vectorMultiply(x1v, vkn);
		} while (Math.abs((lambt1n - lambt1v) / lambt1n) > e);

		double lambn = 1 / lambt1n;
		double[] xn = x1v;

		return new SaidaPotencia(lambn, xn);
	}

	public SaidaPotencia potenciaDeslocamento(double[][] A, double[] v0, double e, double u) {
		int N = A.length;

		double[][] Ac = mOP.matrixSubtract(A, mOP.matrixMultiply(mOP.matrixIdentity(N), u));

		SaidaPotencia lambx = potenciaInversa(Ac, v0, e);

		return new SaidaPotencia(lambx.getAutovalor() + u, lambx.getAutovetor());
	}
}
