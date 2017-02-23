package com.company;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Zivile on 2017-01-11.
 */
public class Atlyginimas extends Income implements Serializable {

    private konstantos.PajamuTipai tipas;

    public Atlyginimas(double pajamos1) {
        super(pajamos1);
        tipas= konstantos.PajamuTipai.ATLYGINIMAS;
    }

    @Override
    protected void setPaj(double atlyg1) {pajamos=atlyg1;}

    @Override
    public void setData (LocalDate data1) {data=data1;}
    @Override
    public LocalDate getData() {return data; }

    @Override
    double getPajamos() {
        return pajamos;
    }

    @Override
    konstantos.PajamuTipai getTipas() {
        return tipas;
    }


}

