package com.company;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zivile on 2017-01-11.
 */
public class SettingsReader {
    String XMLFile = "";
    public List<MeniuItem> menu = new ArrayList<MeniuItem>();

    public SettingsReader(String pXMLFile){
        XMLFile = pXMLFile;
    }

    public void ReadMenu(){
        try {
            File fXmlFile = new File(XMLFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("menuItem_0");
            int depth = 0;
            ReadElements(nList, menu, depth);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ReadElements(NodeList nList, List<MeniuItem> pmenu, int depth){
        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                MeniuItem lXMLMenu = new MeniuItem();
                lXMLMenu.id = Integer.parseInt(eElement.getAttribute("id"));
                lXMLMenu.visible = Boolean.parseBoolean(eElement.getAttribute("visible"));
                lXMLMenu.name = eElement.getAttribute("name");
                lXMLMenu.text = eElement.getAttribute("text");
                NodeList lnList = eElement.getElementsByTagName("menuItem_" + (depth+1));
                ReadElements(lnList, lXMLMenu.submenu, depth+1);
                pmenu.add(lXMLMenu);
            }
        }
    }

}


