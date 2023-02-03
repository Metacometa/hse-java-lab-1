package laba_1;

import java.util.Scanner;

public class Complex extends Real {
    private double b;

    //Constructors
    Complex() {
        super();
    }
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
    public void input() {
        System.out.println("Enter a real part: ");
        Scanner input = new Scanner(System.in);
        this.setA(input.nextFloat());
        System.out.println("Enter an imaginary part: ");
        this.setB(input.nextFloat());
    }
    public void print() {
        System.out.print(this.getA() + " + " + this.getB() + "i");
    }
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
    public double getB() {
        return b;
    }

    //Setters
    public void setB(float b) {
        this.b = b;
    }
}
