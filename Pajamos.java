package com.company;


import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Zivile on 2017-01-11.
 */
public class Pajamos implements Serializable {
    public ArrayList<Income> arrayOfIncome = new ArrayList<>();
    private Income pajamosN;
    protected LocalDate dateStart;
    protected LocalDate dateFinish;
    protected double min;
    protected double max;
    protected LocalDate minDate;
    protected LocalDate maxData;



    void setPajamos(int nr) {
        Scanner sc = new Scanner(System.in);
        try {
            switch (nr) {
                case 1: {
                    System.out.println(konstantos.CONST_IVESKITE_ATLYGINIMA);
                    Double input=sc.nextDouble();
                    if (checkInput(input)){
                        pajamosN = new Atlyginimas(input);
                        changeDate();
                        arrayOfIncome.add(pajamosN);}
                    break;
                }
                case 2: {
                    System.out.println(konstantos.CONST_IVESKITE_KITAS_PAJAMAS);
                    Double input=sc.nextDouble();
                    if (checkInput(input)){
                        pajamosN = new KitosPajamos(input);
                        changeDate();
                        arrayOfIncome.add(pajamosN);}
                    break;
                }
            }
        }
        catch (Exception e){System.out.println(konstantos.CONST_NETEISINGAI_IVEDETE_DUOMENIS);}
    }

    public void changeDate (){
        Scanner sc = new Scanner(System.in);
        System.out.println(konstantos.CONST_AR_PAKEISTI_PAJ_DATA);
        if (sc.next().equalsIgnoreCase("t")) {
            System.out.println(konstantos.CONST_IVESKITE_NAUJA_PAJ_DATA);
            LocalDate date = LocalDate.parse(sc.next());
            konstantos.dtf.format(date);
            pajamosN.setData(date);
        }
    }
    public boolean checkInput (double input) {
        if (input<=0){System.out.println(konstantos.CONST_IVEDETE_NEIGIAMUS_DUOMENIS); return false;}
        else return true;
    }

    public ArrayList<Income> getPajamosByType (konstantos.PajamuTipai tipas){
        ArrayList <Income>arrayIncByTipas=new ArrayList<>();
        for (int i=0; i<arrayOfIncome.size();i++){
            konstantos.PajamuTipai tmp=arrayOfIncome.get(i).getTipas();
            if (tmp==tipas) {
                arrayIncByTipas.add(arrayOfIncome.get(i));
            }
        }
        return arrayIncByTipas;
    }

    public Pajamos getMinMax (konstantos.PajamuTipai tipas){
        ArrayList <Income>arrayIncByTipas = getPajamosByType(tipas);
        Collections.sort(arrayIncByTipas, new Comparator<Income>() {
            @Override
            public int compare(Income c1, Income c2) {
                return Double.compare(c1.getPajamos(), c2.getPajamos());
            }
        });
        min=arrayIncByTipas.get(0).getPajamos();
        minDate=arrayIncByTipas.get(0).getData();
        max=arrayIncByTipas.get(arrayIncByTipas.size()-1).getPajamos();
        maxData=arrayIncByTipas.get(arrayIncByTipas.size()-1).getData();
        System.out.println(tipas);
        System.out.println(konstantos.CONST_DIDZIAUSIA_REIKSME+max);
        System.out.println(konstantos.CONST_DIDZIAUSIOS_REIKSMES_DATA+maxData);
        System.out.println(konstantos.CONST_MAZIAUSIA_REIKSME+min);
        System.out.println(konstantos.CONST_MAZIAUSIOS_REIKSMES_DATA+minDate);
        return this;
    }
    public void dateLimits()  {
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
        } catch (Exception e){System.out.println(konstantos.CONST_NETEISINGA_DATA); }
    }
    public double sumPajamos () throws IOException, ParseException {

        double sumPaj = 0;
        for (int i = 0; i < arrayOfIncome.size(); i++) {
            double tmp = arrayOfIncome.get(i).getPajamos();
            LocalDate tmpDate = arrayOfIncome.get(i).getData();
            if ((dateStart == null) || (dateFinish == null)) {
                sumPaj = sumPaj + tmp;
            } else if (tmpDate.isAfter(dateStart) && tmpDate.isBefore(dateFinish)) {
                sumPaj = sumPaj + tmp;
            }
        }
        return sumPaj;
    }
}








