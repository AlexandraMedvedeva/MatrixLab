package com.company;


import java.io.*;
import java.util.logging.Logger;

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws myException, IOException, ClassNotFoundException {
        matrix A = new matrix(3, 3);
        A.fillByRandomValues();

        matrix B = new matrix(3, 3);
        B.fillByRandomValues();

        matrix D = new vector(4);
        D.fillByRandomValues();

        matrix C;

        A.print();
        B.print();
        D.print();

        C = D.transposing();
        C.print();

        try {
            C = A.summation(B);
            System.out.println("C = A + B");
            C.print();

        } catch (IllegalArgumentException e) {
            log.warning("matrix size error");
        }

        try {
            C = A.multiplication(B);
            System.out.println("C = A * B");
            C.print();

            try (FileOutputStream fos = new FileOutputStream("Serialize.txt")) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(C);
                oos.close();
            }

            try (FileInputStream fis = new FileInputStream("Serialize.txt")) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                matrix E = (matrix) ois.readObject();
                System.out.println("deserialized matrix C");
                E.print();
                ois.close();
            }

        } catch (IllegalArgumentException e) {
            log.warning("matrix size error");
        }

        C = A.transposing();
        C.print();
    }
}
