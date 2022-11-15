package com.severle.entry.mixer;

import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class MonoUnit extends Unit{

    @Override
    public Element toElement() {

        int sEnable = 0, m = 0, s = 0;

        if (this.isSend())
            sEnable = 1;
        if (this.isMute())
            m = 1;
        if (this.isSolo())
            s = 1;

        Element monoUnit = new BaseElement("monoUnit");
        Element e;

        e = monoUnit.addElement("iGin");
        e.setText(String.valueOf(this.getGin()));

        e = monoUnit.addElement("sLvl");
        e.setText(String.valueOf(this.getSendLevel()));

        e = monoUnit.addElement("sEnable");
        e.setText(String.valueOf(sEnable));

        e = monoUnit.addElement("m");
        e.setText(String.valueOf(m));

        e = monoUnit.addElement("s");
        e.setText(String.valueOf(s));

        e = monoUnit.addElement("pan");
        e.setText(String.valueOf(this.getPan()));

        e = monoUnit.addElement("vol");
        e.setText(String.valueOf(this.getVol()));

        return monoUnit;
    }
}
