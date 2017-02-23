package com.company;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Zivile on 2017-01-11.
*/
public class KatData {

    Islaidos costs = FileOperations.readIslaidos();
    Pajamos income = FileOperations.readPajamos();
    private boolean a=true;

    public KatData() throws IOException {
    }
    public void kategorija () throws ParseException {

        while (a){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ar norite perziureti pajamu kategorija? t/n");
            String tmp=sc.next();
            if (tmp.equalsIgnoreCase("t")) {
                printPajamos();
                System.out.println("Ar norite issaugoti sia ataskaita i faila? t/n");
                if (sc.next().equalsIgnoreCase("t")) {ataskaitaPajData();a=false; break;}
                else {a=false; break;}
            } else if (tmp.equalsIgnoreCase("n")) {
                System.out.println("Ar norite perziureti islaidu kategorija? t/n");
                if (sc.next().equalsIgnoreCase("t"))
                    {printIslaidos();
                    System.out.println("Ar norite issaugoti sia ataskaita i faila? t/n");
                    if (sc.next().equalsIgnoreCase("t")) {ataskaitaIslData(); a=false; break;}
                    else {a=false; break;}
                }
                else {a=false; break;}
            } else {
                System.out.println("Ivesta neteisinga reiksme");
                a=false;

            }
        }
    }
    public void printPajamos () throws ParseException {
        Collections.sort(income.arrayOfIncome, new Comparator<Income>() {
            @Override
            public int compare(Income c1, Income c2) {
                return  c1.getData().compareTo(c2.getData());
            }
        });
        income.dateLimits();
        System.out.println("Pajamu kategorijos irasai: ");
        for (int i=0; i<income.arrayOfIncome.size(); i++ ){
            LocalDate tmpDate=income.arrayOfIncome.get(i).getData();
            if (income.dateStart == null || income.dateFinish == null) {
                System.out.println("Tipas: "+income.arrayOfIncome.get(i).getTipas());
                System.out.println("Data: "+income.arrayOfIncome.get(i).getData());
                System.out.println("Suma: "+income.arrayOfIncome.get(i).getPajamos());
            } else if (tmpDate.isAfter(income.dateStart) && tmpDate.isBefore(income.dateFinish)) {
                System.out.println("Tipas: "+income.arrayOfIncome.get(i).getTipas());
                System.out.println("Data: "+income.arrayOfIncome.get(i).getData());
                System.out.println("Suma: "+income.arrayOfIncome.get(i).getPajamos());
            } else {System.out.println("Siuo laikotarpiu ivestu duomenu nera");}
        }
    }

    public void printIslaidos () throws ParseException {
        Collections.sort(costs.arrayOfCosts, new Comparator<Costs>() {
            @Override
            public int compare(Costs c1, Costs c2) {
                return  c1.getData().compareTo(c2.getData());
            }
        });
        costs.dateLimits();
        System.out.println("Islaidu kategorijos irasai: ");
        for (int i=0; i<costs.arrayOfCosts.size(); i++ ){
            LocalDate tmpDate=costs.arrayOfCosts.get(i).getData();
            if (costs.dateStart == null || costs.dateFinish == null) {
                System.out.println("Tipas: "+costs.arrayOfCosts.get(i).getTipas());
                System.out.println("Data: "+costs.arrayOfCosts.get(i).getData());
                System.out.println("Suma: "+costs.arrayOfCosts.get(i).getIslaidos());
            } else if (tmpDate.isAfter(costs.dateStart) && tmpDate.isBefore(costs.dateFinish)) {
                System.out.println("Tipas: "+costs.arrayOfCosts.get(i).getTipas());
                System.out.println("Data: "+costs.arrayOfCosts.get(i).getData());
                System.out.println("Suma: "+costs.arrayOfCosts.get(i).getIslaidos());
            } else {System.out.println("Siuo laikotarpiu ivestu duomenu nera");}
        }
    }
    public void ataskaitaPajData(){
        PrintWriter pw = null;
        try {
            File file=new File("PajamosPagalData.csv");
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Tipas;Data;Suma"+"\n");
        for (int i = 0; i < income.arrayOfIncome.size(); i++) {
            builder.append(income.arrayOfIncome.get(i).getTipas().toString()+";"+
                            income.arrayOfIncome.get(i).getData().toString()+";"+
                            income.arrayOfIncome.get(i).getPajamos()+"\n");
        }
        pw.write(builder.toString());
        pw.close();
        System.out.println(konstantos.CONST_ATASKAITA_IRASYTA_I_FAILA+ "PajamosPagalData.csv");
    }
    public void ataskaitaIslData(){
        PrintWriter pw = null;
        try {

            File file=new File("IslaidosPagalData.csv");
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Tipas;Data;Suma"+"\n");
        for (int i = 0; i < costs.arrayOfCosts.size(); i++) {
            builder.append(costs.arrayOfCosts.get(i).getTipas().toString()+";"+
                    costs.arrayOfCosts.get(i).getData().toString()+";"+
                    costs.arrayOfCosts.get(i).getIslaidos()+"\n");
        }
        pw.write(builder.toString());
        pw.close();
        System.out.println("Ataskaita irasyta i faila IslaidosPagalData.csv");
    }
}

