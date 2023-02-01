package laba_1;
import java.util.Scanner;

public class Number {
    private int a;
    private int bi;
    Number() {
        this.a = this.bi = 0;
    }

    Number(int a, int bi) {
        this.a = a;
        this.bi = bi;
    }

    //operations
    public Number add(Number addition) {
        return new Number(this.getA() + addition.getA(), this.getBi() + addition.getBi());
    }

    public Number multiply(Number multiplier) {
        return new Number(this.getA() * multiplier.getA() - this.getBi() * multiplier.getBi(),
                this.getA() * multiplier.getBi() + this.getBi() * multiplier.getA());
    }

    //getters
    public int getA() {
        return this.a;
    }
    public int getBi() {
        return this.bi;
    }

    //input / out
    public void get() {
        System.out.println("Enter 'R' for real number and 'C' for complex:");
        Scanner in = new Scanner(System.in);
        String type = in.nextLine();

        if (type.equals("R")) {
            System.out.println("Enter number:");
            this.a = in.nextInt();
            this.bi = 0;
        }
        else if (type.equals("C")) {
            System.out.println("Enter real part:");
            this.a = in.nextInt();
            System.out.println("Enter imaginary part:");
            this.bi = in.nextInt();
        }
        else {
            System.out.println("You entered " + type + ".");
        }
    }
    public void print() {
        if (this.bi == 0) {
            System.out.print(this.a);
        }
        else if (Math.abs(this.bi) == 1) {
            System.out.print(this.a + " " + this.sign(this.bi) + " i");
        }
        else if (this.bi > 0) {
            System.out.print(this.a + " + " + this.bi + "i");
        }
        else {
            System.out.print(this.a + " - " + (-this.bi) + "i");
        }
    }

    //util
    private char sign(int x) {
        if (x >= 0)
            return '+';
        else
            return '-';
    }
}
