package laba_1;
import java.util.HashMap;
import java.util.InputMismatchException;
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
        main_loop: while(true) {
            System.out.println("Write \"Print help\" for getting all commands");
            switch(in.nextLine()) {
                case "New number":
                    newNumber();
                    break;
                case "Add number":
                    numberOperate("Add");
                    break;
                case "Multiply number":
                    numberOperate("Multiply");
                    break;
                case "New matrix":
                    newMatrix();
                    break;
                case "Add matrix":
                    matrixOperate("Add");
                    break;
                case "Multiply matrix":
                    matrixOperate("Multiply");
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
                case "Print trigonometric complex":
                    ConsoleNumberHandler.printComplexTrigonometric(this.numbers);
                    break;
                case "Print help":
                    printHelp();
                    break;
                case "Stop":
                    break main_loop;
                    default:
            }
        }
    }
    /**
     * This method implements console management of adding or multiplication of numbers
     * @param operation defines add or multiply will be done
     */
    public void numberOperate(String operation) {
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
        System.out.println("Enter name of variable for " + operationName + ":");
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
     * This method implements console management of adding or multiplication of numbers
     * @param operation defines add or multiply will be done
     */
    public void matrixOperate(String operation) {
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
        System.out.println("Enter name of variable for " + operationName + ":");
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
                    result = firstValue.add(secondValue);
                    System.out.println(resultName + " = " + firstName + " + " + secondName + " = ");
                    break;
                case "Multiply":
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
    public void printMatrices() {
        System.out.println("Matrices:");
        for (Map.Entry<String, Matrix> entry: this.matrices.entrySet()) {
            String key = entry.getKey();
            Matrix value = entry.getValue();
            System.out.println("\"" + key + "\" = ");
            ConsoleMatrixHandler.printMatrix(value);
            System.out.println();
        }
    }
    public void newMatrix() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of a new object:");
        String name = in.nextLine();
        this.matrices.put(name, ConsoleMatrixHandler.inputMatrix());
    }
    /**
     * Print all based command for controlling of matrices and numbers via console
     */
    public static void printHelp() {
        System.out.println("Available commands:\n " +
                "\"New number\"\n " +
                "\"Add number\"\n " +
                "\"Multiply number\"\n " +
                "\"New matrix\"\n " +
                "\"Print all\"\n " +
                "\"Print name\"\n " +
                "\"Print matrices\"\n " +
                "\"Print numbers\"\n " +
                "\"Print trigonometric complex\"\n " +
                "\"Print help\"\n " +
                "\"Stop\"");
    }
    /**
     * User input of a new number
     */
    public void newNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of a new number:");
        String name = in.nextLine();
        this.numbers.put(name, ConsoleNumberHandler.inputNumber());
    }
    public void printNumbers() {
        System.out.println("Numbers:");
        for (Map.Entry<String, Number> entry: this.numbers.entrySet()) {
            String key = entry.getKey();
            Number value = entry.getValue();
            System.out.print("\"" + key + "\" = ");
            ConsoleNumberHandler.printNumber(value);
            System.out.println();
        }
    }
}
