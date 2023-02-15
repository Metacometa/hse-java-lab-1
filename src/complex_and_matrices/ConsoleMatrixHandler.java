package complex_and_matrices;
import java.util.Scanner;

/**
 * Implements user input and output of matrices
 */
public class ConsoleMatrixHandler {
    /**
     * Gets user input of matrix size
     **/
    public static Matrix inputMatrixSize(String name) {
        System.out.println("Entering the matrix \"" + name + "\":");
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of rows:");
        int rows = in.nextInt();
        System.out.println("Enter number of columns:");
        int columns = in.nextInt();

        return new Matrix(rows, columns);
    }
    /**
     * Gets user input of matrix values
     **/
    public static Matrix inputMatrix(String name) {
        Matrix m = inputMatrixSize(name);
        for (int i = 0; i < m.getRows(); ++i) {
            for (int j = 0; j < m.getColumns(); ++j) {
                System.out.println("Enter the number in " + name + "[" + i + "][" + j + "]");
                m.setElement(i, j, ConsoleNumberHandler.inputNumber());
            }
        }
        return m;
    }
    /**
     * @param m to pass matrix for printing
     */
    public static void printMatrix(Matrix m) {
        for (int i = 0; i < m.getRows(); ++i) {
            for (int j = 0; j < m.getColumns(); ++j) {
                ConsoleNumberHandler.printNumber(m.getElement(i, j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    /**
     * @param m to find determinant
     * @param name name of m in hashMap
     */
    public static void printDeterminant(Matrix m, String name) {
        System.out.print("Determinant of \"" + name + "\" : ");
        ConsoleNumberHandler.printNumber(m.getDeterminant());
        System.out.println();
    }
}
