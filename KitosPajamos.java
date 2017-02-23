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
public class KitosPajamos extends Income  implements Serializable {

    private konstantos.PajamuTipai tipas;

    KitosPajamos(double pajamos1) {
        super(pajamos1);
        tipas= konstantos.PajamuTipai.KITOS_PAJAMOS;
    }

    @Override
    protected void setPaj(double pajamos1) {
        pajamos=pajamos1;

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
    double getPajamos() {
        return pajamos;
    }

    @Override
    konstantos.PajamuTipai getTipas() {
        return tipas;
    }

}

