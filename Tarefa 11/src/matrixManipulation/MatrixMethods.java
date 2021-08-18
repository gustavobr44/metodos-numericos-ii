package matrixManipulation;

public class MatrixMethods {
	private MatrixOperations mOP = new MatrixOperations();
	
	public double[] LUfactorization(double[][] A, double[] b) {
		int N = A.length;
		
		double[][] nA = A.clone();
		double[] nb = b.clone();
		
		double[][] L = mOP.matrixIdentity(N);
		double m;

		for (int p = 0; p < N; p++) {
			partialPermutation(nA, L, nb, p);

			for (int i = p + 1; i < N; i++) {
				m = -nA[i][p] / nA[p][p];

				for (int j = 0; j < N; j++) {
					nA[i][j] += m * nA[p][j];
				}

				L[i][p] = -m;
			}
		}

		double[] y = successiveReplacements(L, nb);
		double[] x = retroactiveReplacements(nA, y);

		return x;
	}
	
	public int partialPermutation(double[][] U, double[][] L, double[] b, int p) {
		int N = U.length;
		int perm = 0, maior = p;
		
		for (int i = p + 1; i < N; i++) {
			maior = (Math.abs(U[i][p]) > Math.abs(U[maior][p])) ? i : maior;
		}
		
		if (maior != p) {
			double aux;
			perm++;

			for (int j = 0; j < N; j++) {
				aux = U[p][j];
				U[p][j] = U[maior][j];
				U[maior][j] = aux;

				if (L != null && j < p) {
					aux = L[p][j];
					L[p][j] = L[maior][j];
					L[maior][j] = aux;
				}
			}

			aux = b[p];
			b[p] = b[maior];
			b[maior] = aux;
		}

		return perm;
	}
	
	public double[] successiveReplacements(double[][] A, double[] b) {
		int N = A.length;
		double[] x = new double[N];
		double soma;

		for (int i = 0; i < N; i++) {
			soma = 0;

			for (int j = 0; j < i; j++) {
				soma += A[i][j] * x[j];
			}

			x[i] = (b[i] - soma) / A[i][i];
		}

		return x;
	}
	
	public double[] retroactiveReplacements(double[][] A, double[] b) {
		int N = A.length;
		double[] x = new double[N];
		double soma;

		for (int i = N - 1; i >= 0; i--) {
			soma = 0;

			for (int j = N - 1; j > i; j--) {
				soma += A[i][j] * x[j];
			}

			x[i] = (b[i] - soma) / A[i][i];
		}

		return x;
	}
}
