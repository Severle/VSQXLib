package com.severle.entry.mixer;

import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class VsUnit extends Unit{

    public VsUnit(Element vsUnit) {
        super(vsUnit);
        boolean send = false, mute = false, solo = false;

        if (vsUnit.elementText("sEnable").equals("1"))
            send = true;
        if (vsUnit.elementText("m").equals("1"))
            mute = true;
        if (vsUnit.elementText("s").equals("1"))
            solo = true;

        this.setId(Integer.parseInt(vsUnit.elementText("tNo")));
        this.setGin(Integer.parseInt(vsUnit.elementText("iGin")));
        this.setSendLevel(Integer.parseInt(vsUnit.elementText("sLvl")));
        this.setSend(send);
        this.setMute(mute);
        this.setSolo(solo);
        this.setPan(Integer.parseInt(vsUnit.elementText("pan")));
        this.setVol(Integer.parseInt(vsUnit.elementText("vol")));
    }

    public VsUnit() {

    }

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
