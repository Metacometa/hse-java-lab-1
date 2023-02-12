package laba_1;
import java.util.Scanner;

/**
 * Class that implements Matrix
 */
public class Matrix {
    /**
     * Keeps Complex and Real values of matrix
     */
    private Number[][] matrix;
    /**
     * Size of matrix
     */
    private int rows, columns;

    //Constructors
    /**
     * Default constructor that activates user input of a matrix
     */
    Matrix() {
        this.rows = 0;
        this.columns = 0;
        this.matrix = null;
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

    //Math operations
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
    /**
     * @param i index of a row
     * @param j index of a column
     * @return value by indexes
     */
    public Number getElement(int i, int j) {
        return matrix[i][j];
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
    /**
     * @param i index of a row
     * @param j index of a column
     * @param element to set by indexes
     */
    public void setElement(int i, int j, Number element) {
        this.matrix[i][j] = element;
    }
}
