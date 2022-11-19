package com.severle.entry.part;

import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class PartSinger implements ToElement {
    private int tick;

    private int bankSelected;

    private int programChange;

    public PartSinger(int tick, int bankSelected, int programChange) {
        this.tick = tick;
        this.bankSelected = bankSelected;
        this.programChange = programChange;
    }

    public PartSinger(PartSinger partSinger) {
        this.tick = partSinger.getTick();
        this.bankSelected = partSinger.getBankSelected();
        this.programChange = partSinger.getProgramChange();
    }

    public PartSinger(Element singer) {
        this.tick = Integer.parseInt(singer.elementText("t"));
        this.bankSelected = Integer.parseInt(singer.elementText("bs"));
        this.programChange = Integer.parseInt(singer.elementText("pc"));
    }

    public PartSinger() {
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public int getBankSelected() {
        return bankSelected;
    }

    public void setBankSelected(int bankSelected) {
        this.bankSelected = bankSelected;
    }

    public int getProgramChange() {
        return programChange;
    }

    public void setProgramChange(int programChange) {
        this.programChange = programChange;
    }

    public Element toElement() {
        Element singer = new BaseElement("singer");
        Element e;

        e = singer.addElement("t");
        e.setText(String.valueOf(this.tick));

        e = singer.addElement("bs");
        e.setText(String.valueOf(this.bankSelected));

        e = singer.addElement("pc");
        e.setText(String.valueOf(this.programChange));

        return singer;
    }
}
