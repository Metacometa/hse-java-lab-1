package laba_1;

import java.util.Scanner;

public class Complex extends Real {
    private float b;

    //Constructors
    Complex() {
        this.b = 0;
    }
    Complex(float a, float b) {
        super(a);
        this.b = b;
    }

    //Math operations
    public Number2 add(Number2 addition) {
        if (addition instanceof Complex) {
            Complex a = (Complex) addition;
            return new Complex(this.getA() + a.getA(), this.getB() + a.getB());
        }
        else if (addition instanceof Real) {
            Real a = (Real) addition;
            return new Complex(this.getA() + a.getA(), this.getB());
        }
        return new Complex();
    }

    public Number2 multiply(Number2 multiplier) {
        if (multiplier instanceof Complex) {
            Complex m = (Complex) multiplier;
            System.out.println("ALL IS CORRECT");;
            return new Complex(this.getA() * m.getA() - this.getB() * m.getB(),
                    this.getA() * m.getB() + this.getB() * m.getA());
        }
        else if (multiplier instanceof Real) {
            Real m = (Real) multiplier;
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

    //Getters
    public float getB() {
        return b;
    }

    //Setters
    public void setB(float b) {
        this.b = b;
    }
}
