package com.company;

import java.time.format.DateTimeFormatter;

/**
 * Created by Zivile on 2017-01-20.
 */
public class konstantos {
    public static enum IslaiduTipai {
        AUTO_ISLAIDOS,
        BUSTO_ISLAIDOS,
        MAISTO_ISLAIDOS,
        KITOS_ISLAIDOS;
    }
    public static enum PajamuTipai {
        ATLYGINIMAS,
        KITOS_PAJAMOS;
    }

    protected static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    protected static final String CONST_IVESKITE_AUTO_ISL="Iveskite islaidas automobiliui";
    protected static final String CONST_IVESKITE_BUSTO_ISL="Iveskite islaidas bustui";
    protected static final String CONST_IVESKITE_MAISTO_ISL="Iveskite islaidas maistui";
    protected static final String CONST_IVESKITE_KT_ISL="Iveskite kitas islaidas";
    protected static final String CONST_AR_PAKEISTI_ISL_DATA="Ar norite pakeisti islaidu data? (t/n)";
    protected static final String CONST_IVESKITE_NAUJA_DATA="Iveskite islaidu data formatu YYYY-MM-DD";
    protected static final String CONST_NETEISINGAI_IVEDETE_DUOMENIS="Neteisingai ivedete duomenis, iveskite is naujo";
    protected static final String CONST_AR_PERZIURET_KONK_LAIKO_DUOMENIS="Ar norite perziureti konkretaus laikotarpio duomenis? t/n";
    protected static final String CONST_IVESKITE_PRAD_DATA="Iveskite pradine data, nuo kurios norite formuoti ataskaita, formatu YYYY-MM-DD";
    protected static final String CONST_IVESKITE_GALUT_DATA="Iveskite galutine data, iki kurios norite formuoti ataskaita, formatu YYYY-MM-DD";
    protected static final String CONST_PROGRAMA_PARODYS_VISUS="Programa parodys visus ivestus duomenis";
    protected static final String CONST_IVESKITE_ATLYGINIMA="Iveskite atlyginima";
    protected static final String CONST_IVESKITE_KITAS_PAJAMAS="Iveskite kitas pajamas";
    protected static final String CONST_AR_PAKEISTI_PAJ_DATA="Ar norite pakeisti pajamu data? (t/n)";
    protected static final String CONST_IVESKITE_NAUJA_PAJ_DATA="Iveskite pajamu data formatu YYYY-MM-DD";
    protected static final String CONST_DIDZIAUSIOS_MAZIAUSIOS_PAJAMOS="Didziausios ir maziausios pajamos: ";
    protected static final String CONST_DIDZIAUSIA_REIKSME="Didziausia reiksme: ";
    protected static final String CONST_DIDZIAUSIOS_REIKSMES_DATA="Didziausio rezultato data: ";
    protected static final String CONST_MAZIAUSIA_REIKSME="Maziausia reiksme: ";
    protected static final String CONST_MAZIAUSIOS_REIKSMES_DATA="Maziausio rezultato data: ";
    protected static final String CONST_DIDZIAUSIOS_MAZIAUSIOS_ISLAIDOS="Didziausios ir maziausios islaidos: ";
    protected static final String CONST_AR_IRASYTI_ATASKAITA_I_FAILA="Ar norite issaugoti sia ataskaita i faila?";
    protected static final String CONST_ATASKAITA_IRASYTA_I_FAILA="Ataskaita irasyta i faila ";
    protected static final String CONST_LAIKOTARPIS="Ataskaitos laikotarpis ";
    protected static final String CONST_PRADINIS_LIKUTIS="Pradinis likutis ";
    protected static final String CONST_GAUTA="Gauta pajamu ";
    protected static final String CONST_ISLEISTA="Isleista ";
    protected static final String CONST_GALINIS_LIKUTIS="Galutinis likutis ";
    protected static final String CONST_NETEISINGA_DATA="Ivedete neteisinga data, programa parodys visus duomenis";
    protected static final String CONST_NETEISINGAS_PASIRINKIMAS="Ivedete neteisinga raide, ataskaita neirasyta i faila";
    protected static final String CONST_BALANSAS="-----Balansas------";
    protected static final String CONST_PAJAMOS="Pajamos: ";
    protected static final String CONST_ISLAIDOS="Islaidos: ";
    protected static final String CONST_LIKUTIS="Likutis: ";
    protected static final String CONST_NERA_DUOMENU="Siuo laikotarpiu ivestu duomenu nera";
    protected static final String CONST_LIKUTIS_TEIGIAMAS="Likutis teigiamas";
    protected static final String CONST_LIKUTIS_NEIGIAMAS="Likutis neigiamas";
    protected static final String CONST_FAILO_NERA="Tokio failo nera";
    protected static final String CONST_IVEDETE_NEIGIAMUS_DUOMENIS="Ivesta reiksme negali buti mazesne uz nuli";
    protected static final String CONST_PROGRAMOS_APRASYMAS=" Programa Finansai skirta kasdieniniu pajamu ir islaidu registravimui " +
            "ir saugojimui.\n Naudodami sia programa galesite efektyviai valdyti savo finansus ir sutaupyti. \n Programa " +
            "formuoja keturiu rusiu ataskaitas, kurias galite irasyti i .csv failus. \n Irasytos ataskaitos bus saugomos kataloge Finansai." +
            "\n Demesio: ivedamas datas reikia vesti " +
            "formatu YYYY-MM-DD. \n I klausimus reikia atsakyti raide t, jei norite atsakyti taip, ir n, jei norite atsakyti ne. " +
            " \n Norima meniu punkta issirinksite ivede meniu numeri.";
    protected static final String CONST_NETEISINGA_MENIU_REIKSME="Neteisinga meniu reikšmė. Pasirinkite skaičių nuo 1 iki ";




}
