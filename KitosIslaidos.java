package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Zivile on 2017-01-11.
 */
public class KitosIslaidos extends Costs implements Serializable {
    private double kitosIsl;
    private konstantos.IslaiduTipai tipas;

    KitosIslaidos(double islaidos1) {
        super(islaidos1);
        tipas= konstantos.IslaiduTipai.KITOS_ISLAIDOS;
    }

    @Override
    public void setIslaidos(double kitosIsl1) {
        kitosIsl = kitosIsl1;
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




