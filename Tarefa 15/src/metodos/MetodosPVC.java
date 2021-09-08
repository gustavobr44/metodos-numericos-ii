package metodos;

import java.util.Arrays;

import matrixManipulation.MatrixMethods;

public class MetodosPVC {
	static MatrixMethods mME = new MatrixMethods();
	
	static public double[] applyUniPVCMask(double[][] lim, int N, double[] mask) {
		double dx = (lim[1][0] - lim[0][0]) / N;
		
		int lMask = mask.length;
		int maskCenter = (lMask - 1) / 2;

		double[][] A = new double[N - 1][N - 1];
		double[] b = new double[N - 1];
		
		int leftLim = (int)(N * (lim[0][0] - lim[0][0]));
		int rightLim = (int)(N * (lim[1][0] - lim[0][0]));

		for (int i = 1; i < N; i++) {
			for (int j = -maskCenter; j <= maskCenter; j++) {
				if (i + j == leftLim) {
					b[i - 1] += -(mask[j + maskCenter] * lim[0][1]);
				} else if (i + j == rightLim) {
					b[i - 1] += -(mask[j + maskCenter] * lim[1][1]);
				} else {
					A[i - 1][i + j - 1] = mask[j + maskCenter];
				}
			}
		}
		
		double[] y = mME.LUfactorization(A, b);

		return y;
	}
	
	static public double[] applyBiPVCMask(double[][] lim, int N, double[][] mask, double fxy) {
		double dx = (lim[1][0] - lim[0][0]) / N;
		double dy = (lim[3][0] - lim[2][0]) / N;
		
		int nMask = mask.length, mMask = mask[0].length;
		int maskNCenter = (nMask - 1) / 2, maskMCenter = (mMask - 1) / 2;

		int incognitas = N - 1;
		int incognitas2 = incognitas*incognitas;
		double[][] A = new double[incognitas2][incognitas2];
		double[] b = new double[incognitas2];
		Arrays.fill(b, fxy);
		
		int leftLim = (int)(N * (lim[0][0] - lim[0][0]));
		int rightLim = (int)(N * (lim[1][0] - lim[0][0]));
		int bottomLim = (int)(N * (lim[2][0] - lim[2][0]));
		int upperLim = (int)(N * (lim[3][0] - lim[2][0]));

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				for (int k = -maskNCenter; k <= maskNCenter; k++) {
					for (int l = -maskMCenter; l <= maskMCenter; l++) {
						if (j + l == leftLim) {
							b[(i - 1)*(N - 1) + (j - 1)] += -(mask[k + maskNCenter][l + maskMCenter] * lim[0][1]);
						} else if (j + l == rightLim) {
							b[(i - 1)*(N - 1) + (j - 1)] += -(mask[k + maskNCenter][l + maskMCenter] * lim[1][1]);
						} else if (i + k == bottomLim) {
							b[(i - 1)*(N - 1) + (j - 1)] += -(mask[k + maskNCenter][l + maskMCenter] * lim[2][1]);
						} else if (i + k == upperLim) {
							b[(i - 1)*(N - 1) + (j - 1)] += -(mask[k + maskNCenter][l + maskMCenter] * lim[3][1]);
						} else {
							A[(i - 1)*(N - 1) + (j - 1)][(i - 1)*(N - 1) + (j - 1) + k * (N - 1) + l] = mask[k + maskNCenter][l + maskMCenter];
						}
					}
				}
			}
		}
		
		double[] y = mME.LUfactorization(A, b);

		return y;
	}
}
