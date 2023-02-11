package laba_1;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that implements Real numbers
 */
public class Real extends Number {
    /**
     * All class Real is just wrapper for this real value
     * */
    private double a;

    //Constructors
    /**
    * Default constructor that activates user input of a real number
    */
    Real() {
        this.input();
    }
    /**
     * This constructor gets predefined values
     * @param a a to set
     */
    Real(double a) {
        this.a = a;
    }

    //Math operations
    public Number add(Number addition) {
        if (addition instanceof Complex a) {
            return new Complex(this.getA() + a.getA(), a.getB());
        }
        else if (addition instanceof Real a) {
            return new Real(this.getA() + a.getA());
        }
        return new Real();
    }
    public Number multiply(Number multiplier) {
        if (multiplier instanceof Complex m) {
            return new Complex(this.getA() * m.getA(), this.getA() * m.getB());
        }
        else if (multiplier instanceof Real m) {
            return new Real(this.getA() * m.getA());
        }
        return new Real();
    }

    //User input / output

    /**
     * @exception InputMismatchException if inappropriate value was entered;
     */
    public void input() {
        Scanner input;
        while(true) {
            input = new Scanner(System.in);
            System.out.println("Enter a real number: ");
            try {
                this.setA(input.nextFloat());
                break;
            }
            catch (InputMismatchException exception){
                System.out.println("You entered inappropriate value, enter again!");
            }
        }
    }
    public void print() {
        System.out.print(this.getA());
    }

    //Getters
    /**
     * @return real value
     */
    public double getA() {
        return a;
    }

    //Setters
    /**
     * @param a a to set
     */
    public void setA(float a) {
        this.a = a;
    }

}
