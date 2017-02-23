package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by Zivile on 2017-01-18.
 */
abstract class Costs implements Serializable {
        Double islaidos;
        LocalDate data;
        private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        Costs (double islaidos1) {
            islaidos=islaidos1;
            data = LocalDate.now();
        }

        abstract void setIslaidos(double islaidos1);
        abstract void setData(LocalDate data1);
        abstract LocalDate getData();
        abstract double getIslaidos();
        abstract konstantos.IslaiduTipai getTipas();
    }

