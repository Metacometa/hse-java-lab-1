package laba_1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class that manages console input and output of numbers and matrices
 */
public class ConsoleHandler {
    /**
     * This method is starting of console getting and printing of matrices and numbers
     */
    public void start() {
        Scanner in = new Scanner(System.in);
        HashMap<String, Number> numbers = new HashMap<>();
        HashMap<String, Matrix> matrices = new HashMap<>();
        main_loop: while(true) {
            System.out.println("Write \"Print help\" for getting all commands");
            switch(in.nextLine()) {
                case "New number":
                    newNumber(numbers);
                    break;
                case "Add number":
                    numberOperate("Add", numbers);
                    break;
                case "Multiply number":
                    numberOperate("Multiply", numbers);
                    break;
                case "New matrix":
                    newMatrix(matrices);
                    break;
                case "Add matrix":
                    matrixOperate("Add", matrices);
                    break;
                case "Multiply matrix":
                    matrixOperate("Multiply", matrices);
                    break;
                case "Print all":
                    break;
                case "Print numbers":
                    printNumbers(numbers);
                    break;
                case "Print matrices":
                    printMatrices(matrices);
                    break;
                case "Print trigonometric complex":
                    printComplexTrigonometric(numbers);
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
     * @param numbers is needed in order to add new number
     */
    public void numberOperate(String operation, HashMap<String, Number> numbers) {
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
        if (numbers.containsKey(firstName)) {
            firstValue = numbers.get(firstName);
        } else {
            System.out.println("Number '" + firstName + "' does not exist");
            return;
        }

        System.out.println("Enter name of second " + variableName + ":");
        String secondName = in.nextLine();
        Number secondValue;
        if (numbers.containsKey(secondName)) {
            secondValue = numbers.get(secondName);
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

        result.print();
        System.out.println();
        numbers.put(resultName, result);
    }
    /**
     * This method implements console management of adding or multiplication of numbers
     * @param operation defines add or multiply will be done
     * @param matrices is needed in order to add new matrix
     */
    public void matrixOperate(String operation, HashMap<String, Matrix> matrices) {
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
        if (matrices.containsKey(firstName)) {
            firstValue = matrices.get(firstName);
        } else {
            System.out.println("Number '" + firstName + "' does not exist");
            return;
        }

        System.out.println("Enter name of second " + variableName + ":");
        String secondName = in.nextLine();

        Matrix secondValue;
        if (matrices.containsKey(secondName)) {
            secondValue = matrices.get(secondName);
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

            result.print();
            System.out.println();
            matrices.put(resultName, result);
        }
        catch (IllegalArgumentException exception){
            System.out.println("Incorrect sizes of matrices");
        }
    }

    /**
     * @param numbers passes all complex numbers in a method
     */
    public void printComplexTrigonometric(HashMap<String, Number> numbers) {
        boolean noPrintings = true;
        for (Map.Entry<String, Number> entry: numbers.entrySet()) {
            String key = entry.getKey();
            Number value = entry.getValue();
            if (value instanceof Complex) {
                System.out.print(key + " = ");
                ((Complex) value).printTrigonometric();
                noPrintings = false;
            }
        }

        if (noPrintings) {
            System.out.println("There are no complex numbers");
        }
    }
    /**
     * @param numbers passes all numbers in a method
     */
    public void printNumbers(HashMap<String, Number> numbers) {
        for (Map.Entry<String, Number> entry: numbers.entrySet()) {
            String key = entry.getKey();
            Number value = entry.getValue();
            System.out.print("\"" + key + "\" = ");
            value.print();
            System.out.println();
        }
    }
    /**
     * @param matrices passes all matrices in a method
     */
    public void printMatrices(HashMap<String, Matrix> matrices) {
        for (Map.Entry<String, Matrix> entry: matrices.entrySet()) {
            String key = entry.getKey();
            Matrix value = entry.getValue();
            System.out.println("\"" + key + "\" = ");
            value.print();
            System.out.println();
        }
    }
    /**
     * User input of a new number
     * @param numbers here will be added a new number
     */
    public void newNumber(HashMap<String, Number> numbers) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of a new object:");
        String name = in.nextLine();
        while (true) {
            System.out.println("Enter 'R' for real number and 'C' for complex:");
            String type = in.nextLine();
            if (type.equals("R")) {
                numbers.put(name, new Real());
                break;
            }
            else if (type.equals("C")) {
                numbers.put(name, new Complex());
                break;
            }
        }
    }
    /**
     * User input of a new matrix
     * @param matrices here will be added a new matrix
     */
    public void newMatrix(HashMap<String, Matrix> matrices) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of a new object:");
        String name = in.nextLine();
        matrices.put(name, new Matrix());
    }
    /**
     * Print all based command for controlling of matrices and numbers via console
     */
    public void printHelp() {
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
}
