package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by Zivile on 2017-01-11.
 */
public class KatLikuciai {

    private LocalDate firstDate;
    private LocalDate lastDate;
    private double pradLikutis;
    private double gauta;
    private double isleista;
    private double galLikutis;

    Islaidos costs = FileOperations.readIslaidos();
    Pajamos income = FileOperations.readPajamos();
    Scanner sc=new Scanner(System.in);

    public KatLikuciai() throws IOException {
    }

    public void datuIntervalas(){

        System.out.println(konstantos.CONST_IVESKITE_PRAD_DATA);
        firstDate = LocalDate.parse(sc.next());
        System.out.println(konstantos.CONST_IVESKITE_GALUT_DATA);
        lastDate = LocalDate.parse(sc.next());
        System.out.println(konstantos.CONST_LAIKOTARPIS+firstDate+" - "+lastDate);
    }

    public double pradinisLikutis() throws IOException, ParseException {

        income.dateStart=LocalDate.parse("1970-01-01");
        costs.dateStart=LocalDate.parse("1970-01-01");
        income.dateFinish=firstDate.minusDays(1);
        costs.dateFinish=firstDate.minusDays(1);
        pradLikutis=income.sumPajamos()-costs.sumIslaidos();
        System.out.println(konstantos.CONST_PRADINIS_LIKUTIS+pradLikutis);
        return pradLikutis;

    }

    public void galinisLikutis() throws IOException, ParseException {
        income.dateStart=firstDate;
        income.dateFinish=lastDate;
        gauta=income.sumPajamos();
        System.out.println(konstantos.CONST_GAUTA+gauta);
        costs.dateStart=firstDate;
        costs.dateFinish=lastDate;
        isleista=costs.sumIslaidos();
        System.out.println(konstantos.CONST_ISLEISTA+isleista);
        galLikutis=pradLikutis+gauta-isleista;
        System.out.println(konstantos.CONST_GALINIS_LIKUTIS+galLikutis);
    }

    private void writeAtaskaita() {
        PrintWriter pw = null;
        try {
            File file=new File("Likuciai.csv");
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        builder.append(konstantos.CONST_LAIKOTARPIS+";"+income.dateStart+";"+income.dateFinish+";"+"\n");
        builder.append(konstantos.CONST_PRADINIS_LIKUTIS+";"+pradLikutis+"\n");
        builder.append(konstantos.CONST_GAUTA+";"+gauta+"\n");
        builder.append(konstantos.CONST_ISLEISTA+";"+isleista+"\n");
        builder.append(konstantos.CONST_GALINIS_LIKUTIS+";"+galLikutis+"\n");
        pw.write(builder.toString());
        pw.close();
    }
    public void rodykAtaskaita() throws IOException, ParseException {
        datuIntervalas();
        pradinisLikutis();
        galinisLikutis();
        System.out.println(konstantos.CONST_AR_IRASYTI_ATASKAITA_I_FAILA);
        String str=sc.next();
        if (str.equalsIgnoreCase("t")) {
            writeAtaskaita();
            System.out.println(konstantos.CONST_ATASKAITA_IRASYTA_I_FAILA + "Likuciai.csv");
        } else  if (str.equalsIgnoreCase("n"));
        else System.out.println(konstantos.CONST_NETEISINGAS_PASIRINKIMAS);
    }

}
