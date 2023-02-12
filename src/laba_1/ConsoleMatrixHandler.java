package laba_1;
import java.util.Scanner;

/**
 * Implements user input and output of matrices
 */
public class ConsoleMatrixHandler {
    /**
     * Gets user input of matrix size
     **/
    public static Matrix inputMatrixSize() {
        System.out.println("Entering the matrix:");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int rows = in.nextInt();
        System.out.println("Enter number of columns");
        int columns = in.nextInt();

        return new Matrix(rows, columns);
    }
    /**
     * Gets user input of matrix values
     **/
    public static Matrix inputMatrix() {
        Matrix m = inputMatrixSize();
        for (int i = 0; i < m.getRows(); ++i) {
            for (int j = 0; j < m.getColumns(); ++j) {
                System.out.println("Enter the number in Matrix[" + i + "][" + j + "]");
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
}
