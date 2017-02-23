package com.company;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Zivile on 2017-01-11.
 */
public class FileOperations {
    public static void writePajamosToFile(Pajamos nPajamos) throws FileNotFoundException {
        try {

            FileOutputStream fout = new FileOutputStream("src/Pajamos.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(nPajamos);
            oos.close();
        } catch (Exception e) {
            System.out.println("Issaugoti nepavyko");
            e.printStackTrace();
        }
        ;
    }

    public static Pajamos readPajamos() {
        //FileInputStream fis=null;
        ObjectInputStream ois=null;
        Pajamos tmp = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("src/Pajamos.txt"));
            tmp = (Pajamos) ois.readObject();
            return tmp;
            } catch (Exception e){e.printStackTrace();
            } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            return new Pajamos();
        }





    public static void writeIslaidosToFile(Islaidos nIslaidos) throws FileNotFoundException {
        try {

            FileOutputStream fout = new FileOutputStream("src/Islaidos.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(nIslaidos);
            oos.close();
        } catch (Exception e) {
            System.out.println("Issaugoti nepavyko");
        }
        ;
    }

    public static Islaidos readIslaidos() {
        FileInputStream fis;
        ObjectInputStream ois;
        Islaidos tmp = null;
        try {
            fis = new FileInputStream("src/Islaidos.txt");
            ois = new ObjectInputStream(fis);
            try {
                tmp = (Islaidos) ois.readObject();
                return tmp;
            } catch (Exception e) {

            } finally {
                ois.close();
                fis.close();
            }
        } catch (Exception e) {
            System.out.printf(e.getMessage());
            e.printStackTrace();
        }
        return tmp;
    }
}
