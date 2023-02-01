package laba_1;
import java.util.Scanner;

public class Real extends Number2 {
    private float a;

    //Constructors
    Real() {
        this.a = 0;
    }
    Real(float a) {
        this.a = a;
    }

    //Math operations
    public Number2 add(Number2 addition) {
        if (addition instanceof Complex) {
            Complex a = (Complex) addition;
            return new Complex(this.getA() + a.getA(), a.getB());
        }
        else if (addition instanceof Real) {
            Real a = (Real) addition;
            return new Real(this.getA() + a.getA());
        }
        return new Real();
    }

    public Number2 multiply(Number2 multiplier) {
        if (multiplier instanceof Complex) {
            Complex m = (Complex) multiplier;
            return new Complex(this.getA() * m.getA(), this.getA() * m.getB());
        }
        else if (multiplier instanceof Real) {
            Real m = (Real) multiplier;
            return new Real(this.getA() * m.getA());
        }
        return new Real();
    }

    //User input / output
    public void input() {
        System.out.println("Enter a real number: ");
        Scanner input = new Scanner(System.in);
        a = input.nextFloat();
    }
    public void print() {
        System.out.print(a);
    }

    //Getters
    public float getA() {
        return a;
    }

    //Setters
    public void setA(float a) {
        this.a = a;
    }
}
