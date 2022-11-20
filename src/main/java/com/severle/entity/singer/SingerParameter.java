package com.severle.entity.singer;

import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class SingerParameter implements ToElement {
    private int bre;

    private int bri;

    private int cle;

    private int gen;

    private int ope;

    public SingerParameter(int bre, int bri, int cle, int gen, int ope) {
        this.bre = bre;
        this.bri = bri;
        this.cle = cle;
        this.gen = gen;
        this.ope = ope;
    }

    public SingerParameter(int bre, int bri, int cle, int gen) {
        this.bre = bre;
        this.bri = bri;
        this.cle = cle;
        this.gen = gen;
        this.ope = 0;
    }

    public SingerParameter(SingerParameter singerParameter) {
        this.bre = singerParameter.getBre();
        this.bri = singerParameter.getBri();
        this.cle = singerParameter.getCle();
        this.gen = singerParameter.getGen();
        this.ope = singerParameter.getOpe();
    }

    public SingerParameter(Element vPrm) {
        this.bre = Integer.parseInt(vPrm.elementText("bre"));
        this.bri = Integer.parseInt(vPrm.elementText("bri"));
        this.cle = Integer.parseInt(vPrm.elementText("cle"));
        this.gen = Integer.parseInt(vPrm.elementText("gen"));
        this.ope = Integer.parseInt(vPrm.elementText("ope"));
    }

    public SingerParameter() {
    }

    public int getBre() {
        return bre;
    }

    public void setBre(int bre) {
        this.bre = bre;
    }

    public int getBri() {
        return bri;
    }

    public void setBri(int bri) {
        this.bri = bri;
    }

    public int getCle() {
        return cle;
    }

    public void setCle(int cle) {
        this.cle = cle;
    }

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }

    public int getOpe() {
        return ope;
    }

    public void setOpe(int ope) {
        this.ope = ope;
    }

    public Element toElement() {
        Element vPrm = new BaseElement("vPrm");
        Element e;

        e = vPrm.addElement("bre");
        e.setText(String.valueOf(this.bre));

        e = vPrm.addElement("bri");
        e.setText(String.valueOf(this.bri));

        e = vPrm.addElement("cle");
        e.setText(String.valueOf(this.cle));

        e = vPrm.addElement("gen");
        e.setText(String.valueOf(this.gen));

        e = vPrm.addElement("ope");
        e.setText(String.valueOf(this.ope));

        return vPrm;
    }
}
