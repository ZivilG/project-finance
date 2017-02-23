package com.company;

import java.io.*;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Zivile on 2017-01-11.
 */
public class MaxMin implements Serializable {
    Islaidos costs = FileOperations.readIslaidos();
    Pajamos income = FileOperations.readPajamos();

    public MaxMin() throws IOException {
    }

    public void rodykMinMax () throws ParseException {

        System.out.println(konstantos.CONST_DIDZIAUSIOS_MAZIAUSIOS_PAJAMOS);
        income.getMinMax(konstantos.PajamuTipai.ATLYGINIMAS);
        income.getMinMax(konstantos.PajamuTipai.KITOS_PAJAMOS);
    }
    public void rodykMinMaxIslaidos () throws ParseException {

        System.out.println(konstantos.CONST_DIDZIAUSIOS_MAZIAUSIOS_ISLAIDOS);
        costs.getMinMax(konstantos.IslaiduTipai.AUTO_ISLAIDOS);
        costs.getMinMax(konstantos.IslaiduTipai.BUSTO_ISLAIDOS);
        costs.getMinMax(konstantos.IslaiduTipai.KITOS_ISLAIDOS);
        costs.getMinMax(konstantos.IslaiduTipai.MAISTO_ISLAIDOS);
    }
    public void minMax() throws ParseException {
        rodykMinMax();
        rodykMinMaxIslaidos();
        System.out.println(konstantos.CONST_AR_IRASYTI_ATASKAITA_I_FAILA);
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        if (str.equalsIgnoreCase("t")) {
            writeMinMax();
            System.out.println(konstantos.CONST_ATASKAITA_IRASYTA_I_FAILA + "MinMax.csv");
        } else  if (str.equalsIgnoreCase("n"));
                else System.out.println(konstantos.CONST_NETEISINGAI_IVEDETE_DUOMENIS);
    }


    private void writeMinMax() {
        PrintWriter pw = null;
        try {
            File file=new File("MinMax.csv");
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Tipas;Max data;Max reiksme;Min data; Min reiksme"+"\n");
        builder.append("ATLYGINIMAS"+";"+income.getMinMax(konstantos.PajamuTipai.ATLYGINIMAS).maxData+";"+
                income.getMinMax(konstantos.PajamuTipai.ATLYGINIMAS).max+";"+
                income.getMinMax(konstantos.PajamuTipai.ATLYGINIMAS).minDate+";"+
                income.getMinMax(konstantos.PajamuTipai.ATLYGINIMAS).min+"\n");
        builder.append("KITOS PAJAMOS"+";"+income.getMinMax(konstantos.PajamuTipai.KITOS_PAJAMOS).maxData+";"+
                income.getMinMax(konstantos.PajamuTipai.KITOS_PAJAMOS).max+";"+
                income.getMinMax(konstantos.PajamuTipai.KITOS_PAJAMOS).minDate+";"+
                income.getMinMax(konstantos.PajamuTipai.KITOS_PAJAMOS).min+"\n");
        builder.append("BUSTO ISLAIDOS"+";"+costs.getMinMax(konstantos.IslaiduTipai.BUSTO_ISLAIDOS).maxIslData+";"+
                costs.getMinMax(konstantos.IslaiduTipai.BUSTO_ISLAIDOS).maxIsl+";"+
                costs.getMinMax(konstantos.IslaiduTipai.BUSTO_ISLAIDOS).minIslDate+";"+
                costs.getMinMax(konstantos.IslaiduTipai.BUSTO_ISLAIDOS).minIsl+"\n");
        builder.append("AUTOMOBILIO ISLAIDOS"+";"+costs.getMinMax(konstantos.IslaiduTipai.AUTO_ISLAIDOS).maxIslData+";"+
                costs.getMinMax(konstantos.IslaiduTipai.AUTO_ISLAIDOS).maxIsl+";"+
                costs.getMinMax(konstantos.IslaiduTipai.AUTO_ISLAIDOS).minIslDate+";"+
                costs.getMinMax(konstantos.IslaiduTipai.AUTO_ISLAIDOS).minIsl+"\n");
        builder.append("MAISTO ISLAIDOS"+";"+costs.getMinMax(konstantos.IslaiduTipai.MAISTO_ISLAIDOS).maxIslData+";"+
                costs.getMinMax(konstantos.IslaiduTipai.MAISTO_ISLAIDOS).maxIsl+";"+
                costs.getMinMax(konstantos.IslaiduTipai.MAISTO_ISLAIDOS).minIslDate+";"+
                costs.getMinMax(konstantos.IslaiduTipai.MAISTO_ISLAIDOS).minIsl+"\n");
        builder.append("KITOS ISLAIDOS"+";"+costs.getMinMax(konstantos.IslaiduTipai.KITOS_ISLAIDOS).maxIslData+";"+
                costs.getMinMax(konstantos.IslaiduTipai.KITOS_ISLAIDOS).maxIsl+";"+
                costs.getMinMax(konstantos.IslaiduTipai.KITOS_ISLAIDOS).minIslDate+";"+
                costs.getMinMax(konstantos.IslaiduTipai.KITOS_ISLAIDOS).minIsl+"\n");
        pw.write(builder.toString());
        pw.close();
    }


}
