package metodos;

public class MatrixMethods {
	public double[][] transpose(double[][] A) {
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
		
		int N2 = B.length;
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
	
	public double vectorMultiply(double[] A, double[] B) {
		double[][] Am = vectorToMatrix(A);
		double[][] Bm = vectorToMatrix(B);
		
		return matrixMultiply(transpose(Am), Bm)[0][0];
	}
	
	public double vectorModule(double[] A) {
		double[][] Am = vectorToMatrix(A);
		
		return Math.sqrt(matrixMultiply(transpose(Am), Am)[0][0]);
	}
	
	public double[][] vectorToMatrix(double[] A) {
		int N = A.length;
		double[][] B = new double[N][1];
		
		for (int i = 0; i < N; i++) {
			B[i][0] = A[i];
		}
		
		return B;
	}
}
