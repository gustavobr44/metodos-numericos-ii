package matrixManipulation;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MatrixOperations {
	public double[][] matrixTranspose(double[][] A) {
		int N = A.length;
		int M = A[0].length;
		double[][] T = new double[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				T[j][i] = A[i][j];
			}
		}

		return T;
	}

	public double[][] matrixMultiply(double[][] A, double[][] B) {
		int N1 = A.length;
		int M1 = A[0].length;

//		int N2 = B.length;
		int M2 = B[0].length;

		double[][] C = new double[N1][M2];

		for (int i = 0; i < N1; i++) {
			for (int j = 0; j < M2; j++) {
				double sum = 0;

				for (int k = 0; k < M1; k++) {
					sum += A[i][k] * B[k][j];
				}

				C[i][j] = sum;
			}
		}

		return C;
	}
	
	public double[][] matrixMultiply(double[][] A, double x) {
		int N = A.length;
		int M = A[0].length;
		
		double[][] C = new double[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				C[i][j] = A[i][j] * x;
			}
		}
		
		return C;
	}
	
	public double[][] matrixSubtract(double[][] A, double[][] B) {
		int N = A.length;
		int M = A[0].length;
		
		double[][] C = new double[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				C[i][j] = A[i][j] - B[i][j];
			}
		}
		
		return C;
	}
	
	public double[][] matrixIdentity(int N) {
		double[][] I = new double[N][N];

		for (int i = 0; i < N; i++) {
			I[i][i] = 1;
		}

		return I;
	}

	public double vectorMultiply(double[] A, double[] B) {
		double[][] Am = vectorToMatrix(A);
		double[][] Bm = vectorToMatrix(B);

		return matrixMultiply(matrixTranspose(Am), Bm)[0][0];
	}

	public double vectorModule(double[] A) {
		double[][] Am = vectorToMatrix(A);

		return Math.sqrt(matrixMultiply(matrixTranspose(Am), Am)[0][0]);
	}

	public double[][] vectorToMatrix(double[] A) {
		int N = A.length;
		double[][] B = new double[N][1];

		for (int i = 0; i < N; i++) {
			B[i][0] = A[i];
		}

		return B;
	}
	
	public String matrixToString(double[][] A) {
		NumberFormat form = new DecimalFormat("0.00000000");
		String out = "[";
		
		for (int i = 0; i < A.length; i++) {
			out += ("[");
			for (int j = 0; j < A[i].length; j++) {
				out += (form.format(A[i][j]));
				
				if (A[i].length > j + 1) {
					out += (", ");
				} else {
					out += ("]");
				}
			}
			
			if (A.length > i + 1) {
				out += (",\n");
			} else {
				out += ("]");
			}
		}
		
		return out;
	}
	
	public String vectorToString(double[] A) {
		NumberFormat form = new DecimalFormat("0.00000000");
		String out = "[";
		
		for (int i = 0; i < A.length; i++) {
			out += (form.format(A[i]));
			
			if (A.length > i + 1) {
				out += (", ");
			} else {
				out += ("]");
			}
		}
		
		return out;
	}
}
