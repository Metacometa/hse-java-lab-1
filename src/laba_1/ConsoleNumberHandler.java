package laba_1;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Implements user input and output of real and complex numbers
 */
public class ConsoleNumberHandler {
    public static Number inputNumber() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 'R' for real number and 'C' for complex:");
            String type = in.nextLine();
            if (type.equals("R")) {
                return new Real(inputReal());
            }
            else if (type.equals("C")) {
                float complex[] = inputComplex();
                return new Complex(complex[0], complex[1]);
            }
        }
    }
    public static Number getNumber(String input) {
        int index = 0;
        boolean realPartGotten = false;
        boolean plusSignGotten = false;
        boolean imaginaryPartStarted = false;
        String temp = "";
        for (int i = 0; i < input.length(); ++i) {
            if (!realPartGotten) {
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    temp += input.charAt(i);
                }
                else if (input.charAt(i) == '+' || input.charAt(i) == ' ') {
                    realPartGotten = true;
                    temp = "";
                }
                else {
                    throw new NumberFormatException("Incorrect number format");
                }
            }
            else if (!plusSignGotten) {
                if (input.charAt(i) == '+') {
                    plusSignGotten = true;
                    break;
                }
                else if (input.charAt(i) != ' ') {
                    throw new NumberFormatException("Incorrect number format");
                }
            }
            else if (!imaginaryPartStarted) {
                if (input.charAt(i) == 'i' || (input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                    imaginaryPartStarted = true;
                    temp += input.charAt(i);
                }
                else if (input.charAt(i) != ' ') {
                    throw new NumberFormatException("Incorrect complex number format");
                }
            }
            else {
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {

                }
                if (input.charAt(i) == 'i' && i != input.length() - 1) {

                }

            }
        }

        if (realPartGotten && plusSignGotten) {

        }
        return null;
        // throw new NumberFormatException();
    }

    /**
     * @exception InputMismatchException if inappropriate value was entered;
     */
    public static float[] inputComplex() {
        Scanner input = new Scanner(System.in);
        float complex[] = new float[2];
        while(true) {
            System.out.println("Enter a real part: ");
            try {
                complex[0] = input.nextFloat();
                break;
            }
            catch (InputMismatchException exception){
                System.out.println("You entered inappropriate value");
            }
        }
        while(true) {
            System.out.println("Enter an imaginary part: ");
            try {
                complex[1] = input.nextFloat();
                break;
            }
            catch (InputMismatchException exception){
                System.out.println("You entered inappropriate value");
            }
        }
        return complex;
    }
    /**
     * @exception InputMismatchException if inappropriate value was entered;
     */
    public static float inputReal() {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a real number: ");
            try {
                return input.nextFloat();
            }
            catch (InputMismatchException exception){
                System.out.println("You entered inappropriate value, enter again!");
            }
        }
    }
    /**
     * @param value to choose appropriate printing params
     */
    public static void printNumber(Number value) {
        if (value instanceof Real r) {
            System.out.print(r.getA());
        }
        else if (value instanceof Complex c) {
            System.out.print(c.getA() + " + " + c.getB());
        }
    }
    /**
     * @param numbers passes all complex numbers in a method
     */
    public static void printComplexTrigonometric(HashMap<String, Number> numbers) {
        boolean noPrintings = true;
        for (Map.Entry<String, Number> entry: numbers.entrySet()) {
            String key = entry.getKey();
            Number value = entry.getValue();
            if (value instanceof Complex) {
                System.out.print("\"" + key + "\" = ");
                System.out.println(((Complex) value).printTrigonometric());
                noPrintings = false;
            }
        }
        if (noPrintings) {
            System.out.println("There are no complex numbers");
        }
    }
}
