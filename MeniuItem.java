package com.company;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Zivile on 2017-01-11.
 */
public class MeniuItem {
    public int id = 0;
    public boolean visible = true;
    public String name = "";
    public String text = "";
    public List<MeniuItem> submenu = new ArrayList<MeniuItem>();

    public void AddSubmeniu(MeniuItem pSubmeniu){
        submenu.add(pSubmeniu);
    }
}
