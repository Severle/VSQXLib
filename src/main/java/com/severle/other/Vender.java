package com.severle.other;

import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class Vender {
    public static Element toElement() {
        Element vender = new BaseElement("vender");

        vender.addCDATA("Yamaha corporation");

        return vender;
    }
}
