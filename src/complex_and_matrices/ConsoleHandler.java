package complex_and_matrices;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class that manages console input and output of numbers and matrices
 */
public class ConsoleHandler {
    /**
     * Keeps all numbers that user created
     */
    HashMap<String, Number> numbers;
    /**
     * Keep all matrices that user created
     */
    HashMap<String, Matrix> matrices;
    /**
     * This method is starting of console getting and printing of matrices and numbers
     */
    public void start() {
        Scanner in = new Scanner(System.in);
        this.numbers = new HashMap<>();
        this.matrices = new HashMap<>();
        printHelp();
        main_loop: while(true) {
            switch(in.nextLine()) {
                case "Print help":
                    printHelp();
                    break;
                case "New number":
                    newNumber();
                    break;
                case "New matrix":
                    newMatrix();
                    break;
                case "Add number":
                    operateNumber("Add");
                    break;
                case "Multiply number":
                    operateNumber("Multiply");
                    break;
                case "Add matrix":
                    operateMatrix("Add");
                    break;
                case "Multiply matrix":
                    operateMatrix("Multiply");
                    break;
                case "Transpose matrix":
                    transposeMatrix();
                    break;
                case "Find determinant":
                    printDeterminant();
                    break;
                case "Print all":
                    printNumbers();
                    System.out.println();
                    printMatrices();
                    break;
                case "Print numbers":
                    printNumbers();
                    break;
                case "Print matrices":
                    printMatrices();
                    break;
                case "Print complex numbers trigonometrically":
                    ConsoleNumberHandler.printComplexTrigonometric(this.numbers);
                    break;
                case "Stop":
                    break main_loop;
                default:
                    System.out.println("Incorrect command");
                    break;
            }
            System.out.println("Write \"Print help\" for getting all commands");
        }
    }
    /**
     * Print all based command for controlling of matrices and numbers via console
     */
    private static void printHelp() {
        System.out.println("Available commands:\n" +
                "\"Print help\"\n" +
                "\"New number/matrix\"\n" +
                "\"Add number/matrix\"\n" +
                "\"Multiply number/matrix\"\n" +
                "\"Transpose matrix\"\n" +
                "\"Find determinant\"\n" +
                "\"Print all/matrices/numbers/complex numbers trigonometrically\"\n" +
                "\"Stop\"");
    }
    /**
     * User input of a new number
     */
    private void newNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of a new number:");
        String name = getName(in);
        System.out.println("Enter number \"" + name + "\":");
        this.numbers.put(name, ConsoleNumberHandler.inputNumber());
        System.out.print("\"" + name + "\" = ");
        ConsoleNumberHandler.printNumber(this.numbers.get(name));
        System.out.println();
    }
    /**
     * User input of a new matrix
     */
    private void newMatrix() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of a new object:");
        String name = getName(in);
        this.matrices.put(name, ConsoleMatrixHandler.inputMatrix(name));
        System.out.println("\"" + name + "\" = ");
        ConsoleMatrixHandler.printMatrix(this.matrices.get(name));
    }
    /**
     * This method implements console management of adding or multiplication of numbers
     * @param operation defines add or multiply will be done
     */
    private void operateNumber(String operation) {
        Scanner in = new Scanner(System.in);
        String resultName;
        String operationName = "";
        String variableName = "";
        switch(operation) {
            case "Add":
                operationName = "sum";
                variableName = "summand";
                break;
            case "Multiply":
                operationName = "multiplying";
                variableName = "multiplier";
                break;
        }
        System.out.println("Enter name of variable for resulting " + operationName + ":");
        resultName = in.nextLine();

        System.out.println("Enter name of first " + variableName + ":");
        String firstName = in.nextLine();

        Number firstValue;
        if (this.numbers.containsKey(firstName)) {
            firstValue = this.numbers.get(firstName);
        } else {
            System.out.println("Number '" + firstName + "' does not exist");
            return;
        }

        System.out.println("Enter name of second " + variableName + ":");
        String secondName = in.nextLine();
        Number secondValue;
        if (this.numbers.containsKey(secondName)) {
            secondValue = this.numbers.get(secondName);
        } else {
            System.out.println("Number '" + secondName + "' does not exist");
            return;
        }
        Number result;
        switch(operation) {
            case "Add":
                result = firstValue.add(secondValue);
                System.out.println(resultName + " = " + firstName + " + " + secondName + " = ");
                break;
            case "Multiply":
                result = firstValue.multiply(secondValue);
                System.out.println(resultName + " = " + firstName + " * " + secondName + " = ");
                break;
            default:
                result = new Real(0);
        }
        ConsoleNumberHandler.printNumber(result);
        System.out.println();
        this.numbers.put(resultName, result);
    }
    /**
     * This method implements console management of adding or multiplication of matrices
     * @param operation defines add or multiply will be done
     * @exception IllegalArgumentException if matrices with not corresponding sizes are being multiplied or summarising
     */
    private void operateMatrix(String operation) {
        Scanner in = new Scanner(System.in);
        String resultName;
        String operationName = "";
        String variableName = "";
        switch(operation) {
            case "Add":
                operationName = "sum of matrices";
                variableName = "summary matrix";
                break;
            case "Multiply":
                operationName = "multiplication of matrices";
                variableName = "multiplied matrix";
                break;
        }
        System.out.println("Enter name of variable for resulting " + operationName + ":");
        resultName = in.nextLine();

        System.out.println("Enter name of first " + variableName + ":");
        String firstName = in.nextLine();

        Matrix firstValue;
        if (this.matrices.containsKey(firstName)) {
            firstValue = this.matrices.get(firstName);
        } else {
            System.out.println("Number '" + firstName + "' does not exist");
            return;
        }

        System.out.println("Enter name of second " + variableName + ":");
        String secondName = in.nextLine();

        Matrix secondValue;
        if (this.matrices.containsKey(secondName)) {
            secondValue = this.matrices.get(secondName);
        } else {
            System.out.println("Number '" + secondName + "' does not exist");
            return;
        }
        Matrix result;
        try {
            switch(operation) {
                case "Add":
                    if (firstValue.getRows() != secondValue.getRows() || firstValue.getColumns() != secondValue.getColumns()) {
                        throw new IllegalArgumentException("Matrices can't be added");
                    }
                    result = firstValue.add(secondValue);
                    System.out.println(resultName + " = " + firstName + " + " + secondName + " = ");
                    break;
                case "Multiply":
                    if (firstValue.getColumns() != secondValue.getRows()) {
                        throw new IllegalArgumentException("Matrices can't be multiplied");
                    }
                    result = firstValue.multiply(secondValue);
                    System.out.println(resultName + " = " + firstName + " * " + secondName + " = ");
                    break;
                default:
                    result = new Matrix(0,0);
            }
            ConsoleMatrixHandler.printMatrix(result);
            System.out.println();
            this.matrices.put(resultName, result);
        }
        catch (IllegalArgumentException exception){
            System.out.println("Incorrect sizes of matrices");
        }
    }
    /**
     * This method implements console management of matrix transposing
     */
    private void transposeMatrix() {
        System.out.println("Enter the name of matrix that will be transposed");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        if (this.matrices.containsKey(name)) {
            Matrix value = this.matrices.get(name);
            System.out.println("\"" + name + "\" = ");
            ConsoleMatrixHandler.printMatrix(value);
            System.out.println("-->");
            value.transpose();
            ConsoleMatrixHandler.printMatrix(value);
        }
        else {
            System.out.println("Entered matrix name does not exist.");
        }
    }
    /**
     * This method implements console management of determinant calculating
     */
    private void printDeterminant() {
        System.out.println("Enter the name of matrix:");
        Scanner in = new Scanner(System.in);
        Matrix value;
        String name = in.nextLine();
        if (this.matrices.isEmpty()) {
            System.out.println("There is no created matrix");
            return;
        }
        if (this.matrices.containsKey(name)) {
            value = this.matrices.get(name);
            if (value.getColumns() == value.getColumns()) {
                ConsoleMatrixHandler.printDeterminant(value, name);
            }
            else {
                System.out.println("Determinant of this matrix does not exist.");
            }
        }
        else {
            System.out.println("Entered matrix name does not exist.");
        }
        name = in.nextLine();

    }
    /**
     * This method simply prints the number to console
     */
    private void printNumbers() {
        System.out.println("Numbers:");
        for (Map.Entry<String, Number> entry: this.numbers.entrySet()) {
            String key = entry.getKey();
            Number value = entry.getValue();
            System.out.print("\"" + key + "\" = ");
            ConsoleNumberHandler.printNumber(value);
            System.out.println();
        }
    }
    /**
     * This method simply prints the matrix to console
     */
    private void printMatrices() {
        System.out.println("Matrices:");
        for (Map.Entry<String, Matrix> entry: this.matrices.entrySet()) {
            String key = entry.getKey();
            Matrix value = entry.getValue();
            System.out.println("\"" + key + "\" = ");
            ConsoleMatrixHandler.printMatrix(value);
            System.out.println();
        }
    }

    //Util
    private static String getName(Scanner in) {
        boolean incorrect;
        String name;
        while(true) {
            incorrect = false;
            name = in.nextLine();
            if (name.isEmpty()) {
                incorrect = true;
            }
            for (int i = 0; i < name.length(); ++i) {
                if (name.charAt(i) < 'A' || (name.charAt(i) > 'Z' && name.charAt(i) < 'a')
                         || name.charAt(i) > 'z') {
                    incorrect = true;
                    break;
                }
            }
            if (!incorrect) {
                return name;
            }
            else {
                System.out.println("Name must consists only from letters, write it again:");
            }
        }
    }
}
