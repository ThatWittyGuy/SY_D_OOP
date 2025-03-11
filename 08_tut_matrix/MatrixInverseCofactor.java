import java.util.Scanner;

public class MatrixInverseCofactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the matrix (n x n): ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("Enter the elements of the matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int determinant = determinant(matrix, n);
        if (determinant == 0) {
            System.out.println("Matrix is not invertible.");
        } else {
            int[][] cofactorMatrix = cofactor(matrix, n);
            int[][] adjointMatrix = transpose(cofactorMatrix, n);
            int[][] inverseMatrix = multiplyByScalar(adjointMatrix, 1, n);
            inverseMatrix = multiplyByScalar(inverseMatrix, 1 / determinant, n);

            System.out.println("Inverse of the matrix:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ", inverseMatrix[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static int determinant(int[][] matrix, int n) {
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        int det = 0;
        for (int col = 0; col < n; col++) {
            det += Math.pow(-1, col) * matrix[0][col] * determinant(minor(matrix, 0, col, n), n - 1);
        }
        return det;
    }

    public static int[][] minor(int[][] matrix, int rowToRemove, int colToRemove, int n) {
        int[][] minor = new int[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == rowToRemove) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToRemove) continue;
                minor[r][c++] = matrix[i][j];
            }
            r++;
        }
        return minor;
    }

    public static int[][] cofactor(int[][] matrix, int n) {
        int[][] cofactorMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cofactorMatrix[i][j] = (int) Math.pow(-1, i + j) * determinant(minor(matrix, i, j, n), n - 1);
            }
        }
        return cofactorMatrix;
    }

    public static int[][] transpose(int[][] matrix, int n) {
        int[][] transposedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    public static int[][] multiplyByScalar(int[][] matrix, int scalar, int n) {
        int[][] resultMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultMatrix[i][j] = scalar * matrix[i][j];
            }
        }
        return resultMatrix;
    }
}
