package com.severle.entity.mixer;

import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class MonoUnit extends Unit{

    public MonoUnit(Element monoUnit) {
        super(monoUnit);

        boolean send = false, mute = false, solo = false;

        if (monoUnit.elementText("sEnable").equals("1"))
            send = true;
        if (monoUnit.elementText("m").equals("1"))
            mute = true;
        if (monoUnit.elementText("s").equals("1"))
            solo = true;

        this.setGin(Integer.parseInt(monoUnit.elementText("iGin")));
        this.setSendLevel(Integer.parseInt(monoUnit.elementText("sLvl")));
        this.setSend(send);
        this.setMute(mute);
        this.setSolo(solo);
        this.setPan(Integer.parseInt(monoUnit.elementText("pan")));
        this.setVol(Integer.parseInt(monoUnit.elementText("vol")));
    }

    public MonoUnit() {
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
