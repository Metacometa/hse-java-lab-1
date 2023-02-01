package laba_1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Number2 a = new Complex(5,-3);
        Number2 b = new Complex(2,8);
        Number2 c = a.multiply(b);
        a.print();
        b.print();
        c.print();


        System.out.println("\nMatrix part of output");
        Matrix m = new Matrix();
        m.getSize();
        m.getMatrix();
        m.print();
    }
}