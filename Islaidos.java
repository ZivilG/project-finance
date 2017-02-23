package com.company;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by Zivile on 2017-01-11.
 */
public class Islaidos implements Serializable {
    protected ArrayList<Costs> arrayOfCosts=new ArrayList<>();
    private Costs islaidosN;
    protected LocalDate dateStart;
    protected LocalDate dateFinish;
    protected double minIsl;
    protected double maxIsl;
    protected LocalDate minIslDate;
    protected LocalDate maxIslData;


    public void setIsl(int nr) {
        Scanner sc = new Scanner(System.in);
        try {
            switch (nr){
                case 1:{System.out.println(konstantos.CONST_IVESKITE_BUSTO_ISL);
                    Double input=sc.nextDouble();
                    if (checkInput(input)){
                        islaidosN = new Bustas(input);
                        changeDate();
                        arrayOfCosts.add(islaidosN);}
                    break;
                }
                case 2:{System.out.println(konstantos.CONST_IVESKITE_AUTO_ISL);
                    Double input=sc.nextDouble();
                    if (checkInput(input)){
                        islaidosN = new Auto(input);
                        changeDate();
                        arrayOfCosts.add(islaidosN);}
                    break;
                }
                case 3:{System.out.println(konstantos.CONST_IVESKITE_MAISTO_ISL);
                    Double input=sc.nextDouble();
                    if (checkInput(input)){
                        islaidosN = new Maistas(input);
                        changeDate();
                        arrayOfCosts.add(islaidosN);}
                    break;
                }
                case 4:{System.out.println(konstantos.CONST_IVESKITE_KT_ISL);
                    Double input=sc.nextDouble();
                    if (checkInput(input)){
                        islaidosN = new KitosIslaidos(input);
                        changeDate();
                        arrayOfCosts.add(islaidosN);}
                    break;
                }

            }
        } catch (Exception e) {
            System.out.println(konstantos.CONST_NETEISINGAI_IVEDETE_DUOMENIS);
        }
    }
    public boolean checkInput (double input) {
        if (input<=0){System.out.println(konstantos.CONST_IVEDETE_NEIGIAMUS_DUOMENIS); return false;}
        else return true;
    }

    public void changeDate (){
        Scanner sc = new Scanner(System.in);
        System.out.println(konstantos.CONST_AR_PAKEISTI_ISL_DATA);
        if (sc.next().equalsIgnoreCase("t")) {
            System.out.println(konstantos.CONST_IVESKITE_NAUJA_DATA);
            LocalDate date = LocalDate.parse(sc.next());
            konstantos.dtf.format(date);
            islaidosN.setData(date);
        }
    }


    public ArrayList<Costs> getIslaidosByType (konstantos.IslaiduTipai tipas){
        ArrayList <Costs>arrayCostsByTipas=new ArrayList<>();
        for (int i=0; i<arrayOfCosts.size();i++){
            konstantos.IslaiduTipai tmp=arrayOfCosts.get(i).getTipas();
            if (tmp==tipas) {
                arrayCostsByTipas.add(arrayOfCosts.get(i));
            }
        }
        return arrayCostsByTipas;
    }

    public Islaidos getMinMax (konstantos.IslaiduTipai tipas){
        ArrayList <Costs>arrayCostsByTipas = getIslaidosByType(tipas);
        Collections.sort(arrayCostsByTipas, new Comparator<Costs>() {
            @Override
            public int compare(Costs c1, Costs  c2) {
                return Double.compare(c1.getIslaidos(), c2.getIslaidos());
            }
        });
        minIsl=arrayCostsByTipas.get(0).getIslaidos();
        minIslDate=arrayCostsByTipas.get(0).getData();
        maxIsl=arrayCostsByTipas.get(arrayCostsByTipas.size()-1).getIslaidos();
        maxIslData=arrayCostsByTipas.get(arrayCostsByTipas.size()-1).getData();
        System.out.println(tipas);
        System.out.println(konstantos.CONST_DIDZIAUSIA_REIKSME+maxIsl);
        System.out.println(konstantos.CONST_DIDZIAUSIOS_REIKSMES_DATA+maxIslData);
        System.out.println(konstantos.CONST_MAZIAUSIA_REIKSME+minIsl);
        System.out.println(konstantos.CONST_MAZIAUSIOS_REIKSMES_DATA+minIslDate);
        return this;
    }
    public void dateLimits() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println(konstantos.CONST_AR_PERZIURET_KONK_LAIKO_DUOMENIS);
        try {
            if (sc.next().equalsIgnoreCase("t")) {
                System.out.println(konstantos.CONST_IVESKITE_PRAD_DATA);
                dateStart = LocalDate.parse(sc.next());
                System.out.println(konstantos.CONST_IVESKITE_GALUT_DATA);
                dateFinish = LocalDate.parse(sc.next());
            } else {
                System.out.println(konstantos.CONST_PROGRAMA_PARODYS_VISUS);
                dateStart = null;
                dateFinish = null;
            }
        } catch (Exception e) {System.out.println(konstantos.CONST_NETEISINGA_DATA);}
    }
    public double sumIslaidos() throws IOException, ParseException {
        double sumIsl = 0;
        for (int i = 0; i < arrayOfCosts.size(); i++) {
            double tmp = arrayOfCosts.get(i).getIslaidos();
            LocalDate tmpDate = arrayOfCosts.get(i).getData();
            if ((dateStart == null) || (dateFinish == null)) {
                sumIsl = sumIsl + tmp;
            } else if (tmpDate.isAfter(dateStart) && tmpDate.isBefore(dateFinish)) {
                sumIsl = sumIsl + tmp;
            }
        }
        return sumIsl;
    }

}
