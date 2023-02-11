package laba_1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that implements Complex numbers
 */
public class Complex extends Real {
    /**
     * All class is a wrapper for this imaginary value
     */
    private double b;
    /**
     * Default constructor that activates user input of a complex number
     */
    Complex() {
        super();
    }
    /**
     * This constructor gets predefined values
     * @param a real part of to set
     * @param b imaginary part to set
     */
    Complex(double a, double b) {
        super(a);
        this.b = b;
    }

    //Math operations
    public Number add(Number addition) {
        if (addition instanceof Complex a) {
            return new Complex(this.getA() + a.getA(), this.getB() + a.getB());
        }
        else if (addition instanceof Real a) {
            return new Complex(this.getA() + a.getA(), this.getB());
        }
        return new Complex();
    }

    public Number multiply(Number multiplier) {
        if (multiplier instanceof Complex m) {
            System.out.println("ALL IS CORRECT");
            return new Complex(this.getA() * m.getA() - this.getB() * m.getB(),
                    this.getA() * m.getB() + this.getB() * m.getA());
        }
        else if (multiplier instanceof Real m) {
            return new Complex(this.getA() * m.getA(), this.getB() * m.getA());
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
            System.out.println("Enter a real part: ");
            try {
                this.setA(input.nextFloat());
                break;
            }
            catch (InputMismatchException exception){
                System.out.println("You entered inappropriate value");
            }
        }
        while(true) {
            input = new Scanner(System.in);
            System.out.println("Enter an imaginary part: ");
            try {
                this.setB(input.nextFloat());
                break;
            }
            catch (InputMismatchException exception){
                System.out.println("You entered inappropriate value");
            }
        }
    }
    public void print() {
        System.out.print(this.getA() + " + " + this.getB() + "i");
    }

    /**
     * This method prints complex number in a trigonometric form
     */
    public void printTrigonometric() {
        double r = Math.sqrt(this.getA() * this.getA() + this.getB() * this.getB());
        double t = Math.abs(Math.atan(this.getB() / this.getA()))    * 180 / Math.PI;
        if (this.getA() < 0 && this.getB() < 0) {
            t = 180 + t;
        }
        else if (this.getA() < 0) {
            System.out.println(2);
            t = 180 - t;
        }
        else if (this.getB() < 0) {

            t = 360 - t;
        }
        System.out.println(r + " * (cos(" + t + ") + i*sin(" + t +"))");
    }

    //Getters
    /**
     * @return imaginary part of number
     */
    public double getB() {
        return b;
    }
    /**
     * @param b imaginary part to set
     */
    //Setters
    public void setB(float b) {
        this.b = b;
    }
}
