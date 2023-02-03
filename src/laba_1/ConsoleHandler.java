package laba_1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleHandler {
    public void start() {
        Scanner in = new Scanner(System.in);
        HashMap<String, Number> numbers = new HashMap<>();
        main_loop: while(true) {
            System.out.println("Available commands:\n " +
                    "\"New number\"\n " +
                    "\"Print all\"\n " +
                    "\"Print name\"\n " +
                    "\"Print matrices\"\n " +
                    "\"Print numbers\"\n " +
                    "\"Print trigonometric complex\"\n " +
                    "\"Add number\"\n " +
                    "\"Multiply number\"\n " +
                    "\"Stop\"");
            switch(in.nextLine()) {
                case "Print all":
                    break;
                case "New number":
                    newNumber(numbers);
                    break;
                case "Print numbers":
                    printNumbers(numbers);
                    break;
                case "Print trigonometric complex":
                    printComplexTrigonometric(numbers);
                    break;
                case "Add number":
                    numberOperate("Add", numbers);
                    break;
                case "Multiply number":
                    numberOperate("Multiply", numbers);
                    break;
                case "Stop":
                    break main_loop;
                    default:
            }
        }
    }
    public void numberOperate(String operation, HashMap<String, Number> numbers) {
        Scanner in = new Scanner(System.in);
        String resultName;
        switch(operation) {
            case "Add" -> System.out.println("Enter name of variable for sum:");
            case "Multiply" -> System.out.println("Enter name of variable for multiplying:");
        }

        resultName = in.nextLine();

        switch(operation) {
            case "Add" -> System.out.println("Enter name of first summand:");

            case "Multiply" -> System.out.println("Enter name of first multiplier:");
        }

        String firstName = in.nextLine();
        Number firstValue;
        if (numbers.containsKey(firstName)) {
            firstValue = numbers.get(firstName);
        } else {
            System.out.println("Number '" + firstName + "' does not exist");
            return;
        }

        switch(operation) {
            case "Add" -> System.out.println("Enter name of second summand:");
            case "Multiply" -> System.out.println("Enter name of second multiplier:");
        }

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
                System.out.print(resultName + " = " + firstName + " + " + secondName + " = ");
                break;
            case "Multiply":
                result = firstValue.multiply(secondValue);
                System.out.print(resultName + " = " + firstName + " * " + secondName + " = ");
                break;
            default:
                result = new Real(0);
        }

        result.print();
        System.out.println();
        numbers.put(resultName, result);
    }
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
    public void printNumbers(HashMap<String, Number> numbers) {
        for (Map.Entry<String, Number> entry: numbers.entrySet()) {
            String key = entry.getKey();
            Number value = entry.getValue();
            System.out.print("\"" + key + "\": ");
            value.print();
            System.out.println();
        }
    }
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
}
