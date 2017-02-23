package com.company;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by Zivile on 2017-01-11.
 */
public class Balansas {
    public double paj;
    public double isl;
    public LocalDate dateStart;
    public LocalDate dateFinish;
    Islaidos costs = null;
    Pajamos income = null;

    public Balansas() {

    }

    public double BalansoFormavimas(boolean debug) throws IOException, ParseException {
        costs = FileOperations.readIslaidos();
        income = FileOperations.readPajamos();
        if (!debug) income.dateLimits();
        else {
            income.dateStart = null;
            income.dateFinish = null;
        }
        costs.dateStart = income.dateStart;
        costs.dateFinish = income.dateFinish;
        paj = income.sumPajamos();
        isl = costs.sumIslaidos();
        if ((paj + isl) == 0.0) {
            System.out.println(konstantos.CONST_NERA_DUOMENU);
        } else {
            SpausdinkBalansa(paj, isl, debug);
        }
        return (paj - isl);
    }

    public void SpausdinkBalansa(double paj1, double isl1, boolean debug) throws IOException, ParseException {

        System.out.println(konstantos.CONST_BALANSAS);
        System.out.println(konstantos.CONST_PAJAMOS + paj);
        System.out.println(konstantos.CONST_ISLAIDOS + isl);
        System.out.println("___________________");
        System.out.println(konstantos.CONST_LIKUTIS + (paj - isl));
        if (paj >= isl) {
            System.out.println(konstantos.CONST_LIKUTIS_TEIGIAMAS);
        } else {
            System.out.println(konstantos.CONST_LIKUTIS_NEIGIAMAS);
        }
        System.out.println(konstantos.CONST_AR_IRASYTI_ATASKAITA_I_FAILA);
        String str = "n";
        if (!debug) {
            Scanner sc = new Scanner(System.in);
            str = sc.next();
        }
        if (str.equalsIgnoreCase("t")) {
            ataskaitaBalansas(paj, isl);
        } else if (str.equalsIgnoreCase("n")) ;
        else System.out.println(konstantos.CONST_NETEISINGAS_PASIRINKIMAS);
    }


    public void ataskaitaBalansas(double paj1, double isl1) {
        PrintWriter pw = null;
        File file = null;
        try {
            file = new File("Balansas.csv");
            try {
                pw = new PrintWriter(file);
                StringBuilder builder = new StringBuilder();
                builder.append("     " + ";" + konstantos.CONST_BALANSAS + "\n");
                builder.append(konstantos.CONST_PAJAMOS + ";" + paj + "\n");
                builder.append(konstantos.CONST_ISLAIDOS + ";" + isl + "\n");
                builder.append(konstantos.CONST_LIKUTIS + ";" + (paj - isl) + "\n");
                if (paj >= isl) {
                    builder.append(konstantos.CONST_LIKUTIS_TEIGIAMAS);
                } else {
                    builder.append(konstantos.CONST_LIKUTIS_NEIGIAMAS);
                }
                pw.write(builder.toString());
                pw.close();
                System.out.println(konstantos.CONST_ATASKAITA_IRASYTA_I_FAILA + " Balansas.csv");
            } catch (Exception e) {
                System.out.println(konstantos.CONST_FAILO_NERA);
            } finally {
                if (pw != null) {
                    pw.close();
                }
            }
        } catch (Exception e) {
            System.out.println(konstantos.CONST_FAILO_NERA);

        }

    }
}




