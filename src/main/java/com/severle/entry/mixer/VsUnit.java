package com.severle.entry.mixer;

import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class VsUnit extends Unit{
    @Override
    public Element toElement() {

        int sEnable = 0, m = 0, s = 0;

        if (this.isSend())
            sEnable = 1;
        if (this.isMute())
            m = 1;
        if (this.isSolo())
            s = 1;

        Element vsUnit = new BaseElement("vsUnit");
        Element e;

        e = vsUnit.addElement("tNo");
        e.setText(String.valueOf(this.getId()));

        e = vsUnit.addElement("iGin");
        e.setText(String.valueOf(this.getGin()));

        e = vsUnit.addElement("sLvl");
        e.setText(String.valueOf(this.getSendLevel()));

        e = vsUnit.addElement("sEnable");
        e.setText(String.valueOf(sEnable));

        e = vsUnit.addElement("m");
        e.setText(String.valueOf(m));

        e = vsUnit.addElement("s");
        e.setText(String.valueOf(s));

        e = vsUnit.addElement("pan");
        e.setText(String.valueOf(this.getPan()));

        e = vsUnit.addElement("vol");
        e.setText(String.valueOf(this.getVol()));

        return vsUnit;
    }
}
