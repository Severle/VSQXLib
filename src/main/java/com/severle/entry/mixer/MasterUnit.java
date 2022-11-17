package com.severle.entry.mixer;

import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class MasterUnit implements ToElement {
    private int dev;

    private int level;

    private int vol;

    public MasterUnit(int dev, int level, int vol) {
        this.dev = dev;
        this.level = level;
        this.vol = vol;
    }

    public MasterUnit(MasterUnit masterUnit) {
        this.dev = masterUnit.getDev();
        this.level = masterUnit.getLevel();
        this.vol = masterUnit.getVol();
    }

    public MasterUnit() {
    }

    public int getDev() {
        return dev;
    }

    public void setDev(int dev) {
        this.dev = dev;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    @Override
    public Element toElement() {
        Element masterUnit = new BaseElement("masterUnit");
        Element e;

        e = masterUnit.addElement("oDev");
        e.setText(String.valueOf(this.dev));

        e = masterUnit.addElement("rLvl");
        e.setText(String.valueOf(this.level));

        e = masterUnit.addElement("vol");
        e.setText(String.valueOf(this.vol));

        return masterUnit;
    }
}
