package com.company;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Zivile on 2017-01-11.
 */
public class Maistas extends Costs implements Serializable {
    private double maistas;
    private konstantos.IslaiduTipai tipas;

    Maistas(double islaidos1) {
        super(islaidos1);
        tipas= konstantos.IslaiduTipai.MAISTO_ISLAIDOS;
    }
    @Override
    public void setIslaidos(double maistas1) {
        maistas = maistas1;
    }
    @Override
    public void setData(LocalDate data1) {
        data = data1;
    }
    @Override
    public LocalDate getData() {
        return data;
    }
    @Override
    public double getIslaidos() {
        return islaidos;
    }

    @Override
    konstantos.IslaiduTipai getTipas() {
        return tipas;
    }
}


