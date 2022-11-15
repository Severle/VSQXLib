package com.severle.other;

import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class Version {
    public static Element toElement() {
        Element version = new BaseElement("version");

        version.addCDATA("4.0.0.3");

        return version;
    }
}
