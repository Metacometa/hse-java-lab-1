package laba_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Matrix a = new Matrix();
        //Matrix b = new Matrix();
        ConsoleHandler test = new ConsoleHandler();
        test.start();
        //System.out.println("adding of matrices");
        //Matrix c = a.multiply(b);
        //c.print();
        HashMap<String, Matrix> m = new HashMap<>();
        //m.put("A", new Real());
        //m.put("B", new Complex());
        m.put("A", new Matrix());
        m.put("B", new Matrix());

        for (Map.Entry<String, Matrix> entry: m.entrySet()) {
            String key = entry.getKey();
            Matrix value = entry.getValue();
            System.out.print("\"" + key + "\": ");
            value.print();
            //System.out.println();
        }

    }
}