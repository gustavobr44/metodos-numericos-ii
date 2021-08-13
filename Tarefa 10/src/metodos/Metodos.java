package metodos;

import customTypes.*;

public class Metodos {
	public SaidaPotReg potenciaRegular(double[][] A, double[] v0, double e) {
		MatrixMethods mCal = new MatrixMethods();
		
		double lamb1n = 0, lamb1v = lamb1n;
		double[] vkn = v0, vkv = vkn;
		double[] x1v = null;
		
		do {
			lamb1v = lamb1n;
			vkv = vkn;
			
			x1v = new double[vkv.length];
			double mod = mCal.vectorModule(vkv);
			
			for (int i = 0; i < vkv.length; i++) {
				x1v[i] = vkv[i] / mod;
			}
			
			vkn = mCal.transpose(mCal.matrixMultiply(A, mCal.vectorToMatrix(x1v)))[0];
			
			lamb1n = mCal.vectorMultiply(x1v, vkn);
		} while (Math.abs((lamb1n - lamb1v)/lamb1n) > e);
		
		return new SaidaPotReg(lamb1n, x1v);
	}
}
