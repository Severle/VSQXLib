package com.severle.entry.singer;

import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class Singer implements ToElement {
    private int bankSelected;

    private int programChange;

    private String id;

    private String name;

    private SingerParameter vPrm;

    public Singer(int bankSelected, int programChange, String id, String name, SingerParameter vPrm) {
        this.bankSelected = bankSelected;
        this.programChange = programChange;
        this.id = id;
        this.name = name;
        this.vPrm = vPrm;
    }

    public Singer(Singer singer) {
        this.bankSelected = singer.getBankSelected();
        this.programChange = singer.getProgramChange();
        this.id = singer.getId();
        this.name = singer.getName();
        this.vPrm = new SingerParameter(singer.getvPrm());
    }

    public Singer() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SingerParameter getvPrm() {
        return vPrm;
    }

    public void setvPrm(SingerParameter vPrm) {
        this.vPrm = vPrm;
    }


    @Override
    public Element toElement() {
        Element vVoice = new BaseElement("vVoice");
        Element e;

        e = vVoice.addElement("bs");
        e.setText(String.valueOf(this.bankSelected));

        e = vVoice.addElement("pc");
        e.setText(String.valueOf(this.programChange));

        e = vVoice.addElement("id");
        e.addCDATA(this.id);

        e = vVoice.addElement("name");
        e.addCDATA(this.name);

        vVoice.add(this.vPrm.toElement());

        return vVoice;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.id);
    }
}
