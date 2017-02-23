package com.company;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        MenuHandler nMenuHandler = new MenuHandler();
        Pajamos nPajamos=FileOperations.readPajamos();
        Islaidos nIslaidos=FileOperations.readIslaidos();
        System.out.println(konstantos.CONST_PROGRAMOS_APRASYMAS);
        while (true) {
            nMenuHandler.printCurrent();
            String userIn = nMenuHandler.getSelection();
            boolean exitProgram = false;
            switch (userIn) {
                case "mnu1": case "mnu2": case "mnu21": case "mnu22": {
                    nMenuHandler.enterInto(userIn);
                    break;
                }
                case "mnu15": case "mnu213": case "mnu225": case "mnu23": {
                    nMenuHandler.exitFrom();
                    break;
                }
                case "mnu3": {
                    exitProgram = true;
                    break;
                }
                case "mnu11":{
                    KatLikuciai nKatLikuciai=new KatLikuciai();
                    nKatLikuciai.rodykAtaskaita();
                    break;
                }
                case "mnu12":{
                    Balansas nBalansas=new Balansas();
                    nBalansas.BalansoFormavimas(false);
                    break;
                }
                case "mnu13":{
                    KatData nKat=new KatData();
                    nKat.kategorija();
                    break;
                }
                case "mnu14":{
                    MaxMin nMaxMin=new MaxMin();
                    nMaxMin.minMax();
                    break;
                }
                case "mnu211": {
                    nPajamos.setPajamos(1);
                    FileOperations.writePajamosToFile(nPajamos);
                    break;
                }
                case "mnu212": {
                    nPajamos.setPajamos(2);
                    FileOperations.writePajamosToFile(nPajamos);
                    break;
                }
                case "mnu221": {
                    nIslaidos.setIsl(1);
                    FileOperations.writeIslaidosToFile(nIslaidos);
                    break;
                }
                case "mnu222": {
                    nIslaidos.setIsl(2);
                    FileOperations.writeIslaidosToFile(nIslaidos);
                    break;
                }
                case "mnu223": {
                    nIslaidos.setIsl(3);
                    FileOperations.writeIslaidosToFile(nIslaidos);
                    break;
                }
                case "mnu224": {
                    nIslaidos.setIsl(4);
                    FileOperations.writeIslaidosToFile(nIslaidos);
                    break;
                }
                default:
                    System.out.println(konstantos.CONST_NETEISINGA_MENIU_REIKSME + nMenuHandler.getCurrMenuCount());
                    break;
            }
            if (exitProgram) {
                break;
            }
        }

    }
}


