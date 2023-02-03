package laba_1;
import java.util.Scanner;

public class Real extends Number {
    private double a;

    //Constructors
    Real() {
        this.input();
    }
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
    public void input() {
        System.out.println("Enter a real number: ");
        Scanner input = new Scanner(System.in);
        this.setA(input.nextFloat());
    }
    public void print() {
        System.out.print(this.getA());
    }

    //Getters
    public double getA() {
        return a;
    }

    //Setters
    public void setA(float a) {
        this.a = a;
    }

}
