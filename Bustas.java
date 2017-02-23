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
public class Bustas extends Costs implements Serializable {
    private double bustas;
    private konstantos.IslaiduTipai tipas;

    Bustas(double islaidos1) {
        super(islaidos1);
        tipas= konstantos.IslaiduTipai.BUSTO_ISLAIDOS;
    }

    @Override
    public void setIslaidos(double bustas1) {bustas=bustas1;}
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

