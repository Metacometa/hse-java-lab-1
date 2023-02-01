package laba_1;
import java.util.Scanner;

public class Matrix {
    Number2[][] matrix;
    int rows;
    int columns;
    Matrix() {}

    public void getSize() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of rows");
        rows = in.nextInt();
        System.out.println("Enter number of columns");
        columns = in.nextInt();

        matrix = new Number2[rows][columns];
    }
    public void getMatrix() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.println("Enter the number in Matrix[" + i + "][" + j + "]");

                Scanner in = new Scanner(System.in);
                while (true) {
                    System.out.println("Enter 'R' for real number and 'C' for complex:");
                    String type = in.nextLine();
                    if (type.equals("R")) {
                        matrix[i][j] = new Real();
                        matrix[i][j].input();
                        break;
                    }
                    else if (type.equals("C")) {
                        matrix[i][j] = new Complex();
                        matrix[i][j].input();
                        break;
                    }
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                matrix[i][j].print();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
