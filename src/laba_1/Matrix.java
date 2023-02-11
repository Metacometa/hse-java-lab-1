package laba_1;
import java.util.Scanner;

/**
 * Class that implements Matrix
 */
public class Matrix {
    private Number[][] matrix;
    private int rows, columns;

    //Constructors
    /**
     * Default constructor that activates user input of a matrix
     */
    Matrix() {
        this.inputSize();
        this.input();
    }

    /**
     * This constructor gets predefined matrix size
     * @param rows rows to set
     * @param columns columns to set
     */
    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new Number[this.rows][this.columns];
    }

    //math operations
    /**
     * Sum operation
     * @param a is adding up with source matrix
     * @return sum of two matrices
     * @exception IllegalArgumentException if matrices with not corresponding sizes are being adding
     **/
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
    /**
     * Multiply operation
     * @param m is multiplied by source matrix
     * @return multiplication two matrices
     * @exception IllegalArgumentException if matrices with not corresponding sizes are being multiplied
     **/
    public Matrix multiply(Matrix m) {
        if (this.getColumns() != m.getRows()) {
            throw new IllegalArgumentException("Matrices can't be multiplied");
        }
        else {
            Matrix resultMatrix = new Matrix(this.getRows(), m.getColumns());
            for (int i = 0; i < this.getRows(); ++i) {
                for (int j = 0; j < m.getColumns(); ++j) {
                    resultMatrix.matrix[i][j] = this.matrix[i][0].multiply(m.matrix[0][j]);
                    for (int k = 1; k < this.getColumns(); ++k) {
                        resultMatrix.matrix[i][j] = resultMatrix.matrix[i][j].add(this.matrix[i][k].multiply(m.matrix[k][j]));
                    }
                }
            }
            return resultMatrix;
        }
    }

    /**
     * Transposing operation
     */
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
    /**
     * Gets user input of rows and columns of matrix
     **/
    private void inputSize() {
        System.out.println("Entering the matrix:");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of rows");
        this.setRows(in.nextInt());
        System.out.println("Enter number of columns");
        this.setColumns(in.nextInt());

        this.matrix = new Number[this.rows][this.columns];
    }
    /**
     * Gets user input of matrix values
     **/
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
                        break;
                    }
                    else if (type.equals("C")) {
                        matrix[i][j] = new Complex();
                        break;
                    }
                }
            }
        }
    }
    /**
     * Prints a matrix for user
     **/
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

    /**
     * @return number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return number of columns
     */
    public int getColumns() {
        return columns;
    }

    //Setters

    /**
     * @param rows rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @param columns columns to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }
}
