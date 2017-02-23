package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zivile on 2017-01-11.
 */
public class MenuHandler {
    ArrayList<List<MeniuItem>> gMenuStack = new ArrayList<List<MeniuItem>>();


    public MenuHandler(){
        SettingsReader sr = new SettingsReader("src/settings.xml");
        sr.ReadMenu();
        gMenuStack.add(sr.menu);
    }
    public void printCurrent() {
        System.out.println("-------------------Pasirinkite meniu-------------------");
        int index = (gMenuStack.size()) - 1;
        List<MeniuItem> menuToPrint = gMenuStack.get(index);
        for (int i = 0; i < menuToPrint.size(); i++) {
            System.out.println((i + 1) + ". " + menuToPrint.get(i).text);
        }
        System.out.println("-------------------------------------------------------");
    }
    public void enterInto (String menuName){
        int index = (gMenuStack.size()) - 1;
        List<MeniuItem> menuToPrint = gMenuStack.get(index);
        for (int i = 0; i < menuToPrint.size(); i++) {
            if (menuToPrint.get(i).name==menuName){gMenuStack.add(menuToPrint.get(i).submenu);break;}
        }
    }

    public void exitFrom (){
        int index = (gMenuStack.size()) - 1;
        gMenuStack.remove(index);
    }

    public String getSelection (){
        Scanner sc=new Scanner(System.in);
        int userIn=sc.nextInt();
        int index = (gMenuStack.size()) - 1;
        List<MeniuItem> menuToPrint = gMenuStack.get(index);
        for (int i = 0; i < menuToPrint.size(); i++) {
            if ((i+1)==userIn){return menuToPrint.get(i).name;}
        }
        return "";
    }

    public int getCurrMenuCount (){
        int index = (gMenuStack.size()) - 1;
        return gMenuStack.get(index).size();
    }
}
