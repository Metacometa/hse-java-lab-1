package laba_1;
import java.util.Scanner;

public class Matrix {
    private Number[][] matrix;
    private int rows, columns;

    //Constructors
    Matrix() {
        this.inputSize();
        this.input();
    }
    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new Number[this.rows][this.columns];
    }

    //math operations
    public Matrix add(Matrix a) {
        if (this.getRows() != a.getRows() && this.getColumns() != a.getColumns()) {
            throw new IllegalArgumentException("Matrices can't be added");
        }
        else {
            Matrix resultMatrix = new Matrix(this.getRows(), this.getColumns());
            for (int i = 0; i < this.getRows(); ++i) {
                for (int j = 0; j < this.getColumns(); ++j) {
                    resultMatrix.matrix[i][j] = this.matrix[i][j].add(a.matrix[i][j]);
                }
            }
            return resultMatrix;
        }
    }
    public Matrix multiply(Matrix m) {
        if (this.getColumns() != m.getRows()) {
            throw new IllegalArgumentException("Matrices can't be multiplied");
        }
        else {
            Matrix resultMatrix = new Matrix(this.getRows(), m.getColumns());
            for (int i = 0; i < this.getRows(); ++i) {
                for (int j = 0; j < m.getColumns(); ++j) {
                    Number result = new Real();
                    for (int k = 0; k < this.getColumns(); ++k) {
                        Number multiplied = this.matrix[i][k].multiply(m.matrix[k][j]);
                        result = result.add(multiplied);
                    }
                    resultMatrix.matrix[i][j] = result;
                }
            }
            return resultMatrix;
        }
    }
    public void transpose() {
        Matrix transposedMatrix = new Matrix(this.getColumns(), this.getRows());

        for (int i = 0; i < transposedMatrix.getRows(); ++i) {
            for (int j = 0; j < transposedMatrix.getColumns(); ++j) {
                transposedMatrix.matrix[i][j] = this.matrix[j][i];
            }
        }
        this.setRows(transposedMatrix.getRows());
        this.setColumns(transposedMatrix.getColumns());
        this.matrix = transposedMatrix.matrix;
    }

    //User input / output
    private void inputSize() {
        System.out.println("Entering the matrix:");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of rows");
        this.setRows(in.nextInt());
        System.out.println("Enter number of columns");
        this.setColumns(in.nextInt());

        this.matrix = new Number[this.rows][this.columns];
    }
    private void input() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.println("Enter the number in Matrix[" + i + "][" + j + "]");

                Scanner in = new Scanner(System.in);
                while (true) {
                    System.out.println("Enter 'R' for real number and 'C' for complex:");
                    String type = in.nextLine();
                    if (type.equals("R")) {
                        matrix[i][j] = new Real();
                        //matrix[i][j].input();
                        break;
                    }
                    else if (type.equals("C")) {
                        matrix[i][j] = new Complex();
                        //matrix[i][j].input();
                        break;
                    }
                }
            }
        }
    }
    public void print() {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                this.matrix[i][j].print();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    //Getters
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }

    //Setters
    public void setRows(int rows) {
        this.rows = rows;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }
}
