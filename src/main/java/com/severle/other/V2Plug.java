package com.severle.other;

import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class V2Plug {
    public static Element toElement() {
        Element sPlug = new BaseElement("sPlug");
        Element e;

        e = sPlug.addElement("id");
        e.addCDATA("ACA9C502-A04B-42b5-B2EB-5CEA36D16FCE");

        e = sPlug.addElement("name");
        e.addCDATA("VOCALOID2 Compatible Style");

        e = sPlug.addElement("version");
        e.addCDATA("3.0.0.1");

        return sPlug;
    }
}
