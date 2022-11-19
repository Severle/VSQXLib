package com.severle.entry.mixer;

import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class StUnit extends Unit{

    public StUnit(Element stUnit) {
        super(stUnit);

        boolean mute = false, solo = false;

        if (stUnit.elementText("m").equals("1"))
            mute = true;
        if (stUnit.elementText("s").equals("1"))
            solo = true;

        this.setGin(Integer.parseInt(stUnit.elementText("iGin")));
        this.setMute(mute);
        this.setSolo(solo);
        this.setVol(Integer.parseInt(stUnit.elementText("vol")));
    }

    public StUnit() {
    }

    @Override
    public Element toElement() {

        int m = 0, s = 0;

        if (this.isMute())
            m = 1;
        if (this.isSolo())
            s = 1;

        Element stUnit = new BaseElement("stUnit");
        Element e;

        e = stUnit.addElement("iGin");
        e.setText(String.valueOf(this.getGin()));

        e = stUnit.addElement("m");
        e.setText(String.valueOf(m));

        e = stUnit.addElement("s");
        e.setText(String.valueOf(s));

        e = stUnit.addElement("vol");
        e.setText(String.valueOf(this.getVol()));

        return stUnit;
    }
}
