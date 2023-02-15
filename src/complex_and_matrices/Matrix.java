package complex_and_matrices;

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
     * Default constructor
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
     **/
    public Matrix add(Matrix a) {
        Matrix resultMatrix = new Matrix(this.getRows(), this.getColumns());
        for (int i = 0; i < this.getRows(); ++i) {
            for (int j = 0; j < this.getColumns(); ++j) {
                resultMatrix.matrix[i][j] = this.matrix[i][j].add(a.matrix[i][j]);
            }
        }
        return resultMatrix;
    }
    /**
     * Multiply matrices
     * @param m is multiplied by source matrix
     * @return multiplication of two matrices
     **/
    public Matrix multiply(Matrix m) {
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
    /**
     * @return determinant of the matrix
     */
    public Number getDeterminant() {
        if (this.getColumns() == 1) {
            return this.getElement(0,0);
        }
        if (this.getColumns() == 2) {
            Number a = this.getElement(0,0).multiply(this.getElement(1,1));
            Number b = this.getElement(0,1).multiply(this.getElement(1,0));
            b = b.multiply(new Real(-1));
            return a.add(b);
        }

        Number det = new Real(0);
        int minorRow, minorColumn;
        int crossedOutRow = 0;
        for (int crossedOutColumn = 0; crossedOutColumn < this.getColumns(); ++crossedOutColumn) {
            Matrix minor = new Matrix(this.getColumns() - 1, this.getRows() - 1);
            minorRow = 0;
            minorColumn = 0;
            for (int i = 0; i < this.getRows(); ++i) {
                for (int j = 0; j < this.getColumns(); ++j) {
                    if (i != crossedOutRow && j != crossedOutColumn) {
                        minor.setElement(minorRow, minorColumn, this.getElement(i,j));
                        minorColumn++;
                        if (minorColumn > minor.getColumns() - 1) {
                            minorColumn = 0;
                            minorRow++;
                        }
                    }
                }
            }
            Number addition = minor.getDeterminant();
            addition = addition.multiply(new Real(Math.pow(-1,crossedOutRow + crossedOutColumn )));
            addition = addition.multiply(this.getElement(crossedOutRow, crossedOutColumn));
            det = det.add(addition);
        }

        return det;
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
     * @return value from the matrix by indexes
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
