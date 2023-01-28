package laba_1;

public class Main {
    public static void main(String[] args) {

        Number a = new Number(2, 3);
        Number b = new Number(-1, 1);
        a = a.multiply(b);
        a.print();
        Number c = new Number(1, -1);
        Number d = new Number(1, 1);
        c.print();
        d.print();
        Number e = new Number(1, -2);
        e.print();
        Number f = new Number(1, 0);
        f.print();
    }
}