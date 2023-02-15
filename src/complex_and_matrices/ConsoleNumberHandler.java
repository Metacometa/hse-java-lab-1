package complex_and_matrices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Implements user input and output of real and complex numbers
 */
public class ConsoleNumberHandler {
    //Input
    /**
     * @return parsed number
     */
    public static Number inputNumber() {
        Scanner in = new Scanner(System.in);
        String input = "";
        while (true) {
            try {
                input = in.nextLine();
                if (input.isEmpty()) {
                    throw new NumberFormatException("Wrong number format");
                }
                return parseNumber(input);
            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Enter number again:");
        }
    }
    /**
     * This method implements parsing of the user input and getting number from it
     * @param input to parse string
     * @return parsed number
     */
    private static Number parseNumber(String input) {
        int index = 0;
        boolean realPartGotten = false;
        boolean plusOrMinusSignGotten = false;
        boolean imaginaryPartStarted = false;

        int negativeRealMultiplier = 1;
        int negativeImaginaryMultiplier = 1;
        String real = "";
        String imaginary = "";
        for (int i = 0; i < input.length(); ++i) {
            if (!realPartGotten) {
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    real += input.charAt(i);
                }
                else if (input.charAt(i) == '+') {
                    realPartGotten = true;
                    plusOrMinusSignGotten = true;
                }
                else if (input.charAt(i) == '-' && i == 0) {
                    negativeRealMultiplier = -1;
                }
                else if (input.charAt(i) == '-') {
                    realPartGotten = true;
                    plusOrMinusSignGotten = true;
                    negativeImaginaryMultiplier = -1;
                }
                else if (input.charAt(i) == ' ') {
                    realPartGotten = true;
                }
                else {
                    throw new NumberFormatException("Number can't take '" + input.charAt(i) + "' symbol");
                }
            }
            else if (!plusOrMinusSignGotten) {
                if (input.charAt(i) == '+') {
                    plusOrMinusSignGotten = true;
                }
                else if (input.charAt(i) == '-') {
                    plusOrMinusSignGotten = true;
                    negativeImaginaryMultiplier = -1;
                }
                else if (input.charAt(i) != ' ') {
                    throw new NumberFormatException("Incorrect number format");
                }
            }
            else if (!imaginaryPartStarted) {
                if (input.charAt(i) == 'i' || (input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                    imaginaryPartStarted = true;
                    imaginary += input.charAt(i);
                }
                else if (input.charAt(i) != ' ') {
                    throw new NumberFormatException("Complex number can't take '" + input.charAt(i) + "' symbol");
                }
            }
            else {
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    imaginary += input.charAt(i);
                }
                else if (input.charAt(i) == 'i' && i == input.length() - 1) {
                    imaginary += input.charAt(i);
                }
                else {
                    throw new NumberFormatException("Incorrect complex number form");
                }
            }
        }

        if (!imaginaryPartStarted && (real.length() == input.length() || (negativeRealMultiplier == -1 && real.length() + 1 == input.length() ))) {
            return new Real(negativeRealMultiplier * Float.parseFloat(real));
        }
        if (!plusOrMinusSignGotten) {
            throw new NumberFormatException("Incorrect number form");
        }
        else if (!imaginaryPartStarted) {
            throw new NumberFormatException("Incorrect complex number form");
        }

        if (imaginary.charAt(0) == 'i' && imaginary.length() == 1) {
            imaginary = "1";
        }
        else if (imaginary.charAt(0) == 'i' && imaginary.charAt(imaginary.length() - 1) == 'i') {
            throw new NumberFormatException("Number can't take two 'i' symbols");
        }
        else if (imaginary.charAt(0) != 'i' && imaginary.charAt(imaginary.length() - 1) != 'i') {
            throw new NumberFormatException("Number must contains 'i' symbol");
        }
        imaginary = imaginary.replace("i", "");
        return new Complex(negativeRealMultiplier*Float.parseFloat(real),negativeImaginaryMultiplier*Float.parseFloat(imaginary));
    }
    /**
     * This method prints number to console
     * @param value to choose appropriate printing params for real and complex numbers
     */

    //Output
    public static void printNumber(Number value) {
        if (value instanceof Complex c) {
            String operation = "+";
            int imaginaryNegativeMultiplicator = 1;
            if (c.getB() < 0) {
                operation = "-";
                imaginaryNegativeMultiplicator = -1;
            }
            if (Math.abs(c.getB()) != 1) {
                System.out.print(c.getA() + operation + imaginaryNegativeMultiplicator * c.getB() + "i");
            }
            else {
                System.out.print(c.getA() + operation + "i");
            }
        }
        else if (value instanceof Real r) {
            System.out.print(r.getA());
        }

    }
    /**
     * This method prints all existing complex numbers to console
     * @param numbers passes all complex numbers in a method
     */
    public static void printComplexTrigonometric(HashMap<String, Number> numbers) {
        boolean noPrintings = true;
        for (Map.Entry<String, Number> entry: numbers.entrySet()) {
            String key = entry.getKey();
            Number value = entry.getValue();
            if (value instanceof Complex) {
                System.out.print("\"" + key + "\" = ");
                System.out.println(((Complex) value).getTrigonometricForm());
                noPrintings = false;
            }
        }
        if (noPrintings) {
            System.out.println("There are no complex numbers");
        }
    }
}
