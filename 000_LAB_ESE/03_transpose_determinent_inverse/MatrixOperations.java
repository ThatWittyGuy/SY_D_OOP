public class MatrixOperations {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        System.out.println("\nTranspose:");
        int[][] transpose = transpose(matrix);
        printMatrix(transpose);

        System.out.println("\nDeterminant:");
        int determinant = determinant3x3(matrix);
        System.out.println(determinant);

        System.out.println("\nInverse:");
        if (determinant == 0) {
            System.out.println("Inverse not possible (Determinant is 0)");
        } else {
            double[][] inverse = inverse3x3(matrix, determinant);
            printMatrix(inverse);
        }
    }

    // Print method for int matrix
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // Print method for double matrix
    public static void printMatrix(double[][] mat) {
        for (double[] row : mat) {
            for (double val : row) {
                System.out.printf("%.2f\t", val);
            }
            System.out.println();
        }
    }

    // Transpose of matrix
    public static int[][] transpose(int[][] mat) {
        int[][] transposed = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                transposed[j][i] = mat[i][j];
        return transposed;
    }

    // Determinant of 3x3 matrix
    public static int determinant3x3(int[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    // Inverse of 3x3 matrix
    public static double[][] inverse3x3(int[][] m, int det) {
        double[][] inv = new double[3][3];

        // Cofactor matrix and then transpose (adjugate)
        inv[0][0] = (m[1][1] * m[2][2] - m[1][2] * m[2][1]) / (double) det;
        inv[0][1] = (m[0][2] * m[2][1] - m[0][1] * m[2][2]) / (double) det;
        inv[0][2] = (m[0][1] * m[1][2] - m[0][2] * m[1][1]) / (double) det;

        inv[1][0] = (m[1][2] * m[2][0] - m[1][0] * m[2][2]) / (double) det;
        inv[1][1] = (m[0][0] * m[2][2] - m[0][2] * m[2][0]) / (double) det;
        inv[1][2] = (m[0][2] * m[1][0] - m[0][0] * m[1][2]) / (double) det;

        inv[2][0] = (m[1][0] * m[2][1] - m[1][1] * m[2][0]) / (double) det;
        inv[2][1] = (m[0][1] * m[2][0] - m[0][0] * m[2][1]) / (double) det;
        inv[2][2] = (m[0][0] * m[1][1] - m[0][1] * m[1][0]) / (double) det;

        return inv;
    }
}
