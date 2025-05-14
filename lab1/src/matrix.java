import java.util.Arrays;
import java.util.Scanner;

public class matrix {

    public static void matrixx() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Матричные операции");

        while (true) {
            System.out.println("\nВыберите операцию:");
            System.out.println("1. Сложение матриц");
            System.out.println("2. Вычитание матриц");
            System.out.println("3. Умножение матрицы на число");
            System.out.println("4. Умножение матрицы на матрицу");
            System.out.println("5. Транспонирование матрицы");
            System.out.println("6. Вычисление определителя матрицы");
            System.out.println("7. Выход");

            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMatrices(scanner);
                    break;
                case 2:
                    subtractMatrices(scanner);
                    break;
                case 3:
                    multiplyMatrixByScalar(scanner);
                    break;
                case 4:
                    multiplyMatrices(scanner);
                    break;
                case 5:
                    transposeMatrix(scanner);
                    break;
                case 6:
                    calculateDeterminant(scanner);
                    break;
                case 7:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    // ----------- Ввод матриц -----------------
    private static double[][] readMatrix(Scanner scanner, String matrixName) {
        System.out.print("Введите количество строк матрицы " + matrixName + ": ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы " + matrixName + ": ");
        int cols = scanner.nextInt();

        double[][] matrix = new double[rows][cols];
        System.out.println("Введите элементы матрицы " + matrixName + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Элемент [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    // ----------- Печать матрицы -----------------
    private static void printMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Матрица не определена или произошла ошибка.");
            return;
        }
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }


    // ----------- Сложение матриц -----------------
    private static void addMatrices(Scanner scanner) {
        System.out.println("Сложение матриц:");
        double[][] matrixA = readMatrix(scanner, "A");
        double[][] matrixB = readMatrix(scanner, "B");

        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            System.out.println("Ошибка: Матрицы имеют разные размеры. Сложение невозможно.");
            return;
        }

        double[][] result = new double[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("Результат сложения:");
        printMatrix(result);
    }

    // ----------- Вычитание матриц -----------------
    private static void subtractMatrices(Scanner scanner) {
        System.out.println("Вычитание матриц:");
        double[][] matrixA = readMatrix(scanner, "A");
        double[][] matrixB = readMatrix(scanner, "B");

        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            System.out.println("Ошибка: Матрицы имеют разные размеры. Вычитание невозможно.");
            return;
        }

        double[][] result = new double[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }

        System.out.println("Результат вычитания:");
        printMatrix(result);
    }

    // ----------- Умножение матрицы на число -----------------
    private static void multiplyMatrixByScalar(Scanner scanner) {
        System.out.println("Умножение матрицы на число:");
        double[][] matrix = readMatrix(scanner, "A");
        System.out.print("Введите число (скаляр): ");
        double scalar = scanner.nextDouble();

        double[][] result = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }

        System.out.println("Результат умножения на число:");
        printMatrix(result);
    }

    // ----------- Умножение матриц -----------------
    private static void multiplyMatrices(Scanner scanner) {
        System.out.println("Умножение матриц:");
        double[][] matrixA = readMatrix(scanner, "A");
        double[][] matrixB = readMatrix(scanner, "B");

        if (matrixA[0].length != matrixB.length) {
            System.out.println("Ошибка: Количество столбцов матрицы A должно быть равно количеству строк матрицы B.  Умножение невозможно.");
            return;
        }

        double[][] result = new double[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        System.out.println("Результат умножения:");
        printMatrix(result);
    }

    // ----------- Транспонирование матрицы -----------------
    private static void transposeMatrix(Scanner scanner) {
        System.out.println("Транспонирование матрицы:");
        double[][] matrix = readMatrix(scanner, "A");

        double[][] result = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        System.out.println("Транспонированная матрица:");
        printMatrix(result);
    }

    // ----------- Вычисление определителя матрицы -----------------
    private static void calculateDeterminant(Scanner scanner) {
        System.out.println("Вычисление определителя матрицы:");
        double[][] matrix = readMatrix(scanner, "A");

        if (matrix.length != matrix[0].length) {
            System.out.println("Ошибка: Матрица должна быть квадратной для вычисления определителя.");
            return;
        }

        if (matrix.length == 1) {
            System.out.println("Определитель: " + matrix[0][0]);
            return;
        }

        if (matrix.length == 2) {
            double determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            System.out.println("Определитель: " + determinant);
            return;
        }

        // Рекурсивное вычисление определителя для матриц 3x3 и более
        double determinant = determinant(matrix);
        System.out.println("Определитель: " + determinant);
    }

    // Рекурсивная функция для вычисления определителя
    public static double determinant(double[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int i = 0; i < n; i++) {
            double[][] submatrix = new double[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                for (int k = 0, col = 0; k < n; k++) {
                    if (k != i) {
                        submatrix[j - 1][col++] = matrix[j][k];
                    }
                }
            }
            det += matrix[0][i] * Math.pow(-1, i) * determinant(submatrix);
        }
        return det;
    }
}
