package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



public abstract class Income implements Serializable {

        Double pajamos;
        LocalDate data;
        private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        Income (double pajamos1) {
            pajamos=pajamos1;
            data = LocalDate.now();
        }

        abstract void setPaj(double pajamos1);
        abstract void setData(LocalDate data1);
        abstract LocalDate getData();
        abstract double getPajamos();
        abstract konstantos.PajamuTipai getTipas();
    }


