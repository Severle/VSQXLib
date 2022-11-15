package com.severle.entry.track;

import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class MasterTrack implements ToElement {
    private String name;

    private String comment;

    private int resolution;

    private int preMeasure;

    private int timeSigM;

    private int timeSigNu;

    private int timeSigDe;

    private int tempoTick;

    private int tempoValue;

    public MasterTrack(String name, String comment, int resolution, int preMeasure, int timeSigM, int timeSigNu, int timeSigDe, int tempoTick, int tempoValue) {
        this.name = name;
        this.comment = comment;
        this.resolution = resolution;
        this.preMeasure = preMeasure;
        this.timeSigM = timeSigM;
        this.timeSigNu = timeSigNu;
        this.timeSigDe = timeSigDe;
        this.tempoTick = tempoTick;
        this.tempoValue = tempoValue;
    }

    public MasterTrack(MasterTrack masterTrack) {
        this.name = masterTrack.getName();
        this.comment = masterTrack.getComment();
        this.resolution = masterTrack.getResolution();
        this.preMeasure = masterTrack.getPreMeasure();
        this.timeSigM = masterTrack.getTimeSigM();
        this.timeSigNu = masterTrack.getTimeSigNu();
        this.timeSigDe = masterTrack.getTimeSigDe();
        this.tempoTick = masterTrack.getTempoTick();
        this.tempoValue = masterTrack.getTempoValue();
    }

    public MasterTrack() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public int getPreMeasure() {
        return preMeasure;
    }

    public void setPreMeasure(int preMeasure) {
        this.preMeasure = preMeasure;
    }

    public int getTimeSigM() {
        return timeSigM;
    }

    public void setTimeSigM(int timeSigM) {
        this.timeSigM = timeSigM;
    }

    public int getTimeSigNu() {
        return timeSigNu;
    }

    public void setTimeSigNu(int timeSigNu) {
        this.timeSigNu = timeSigNu;
    }

    public int getTimeSigDe() {
        return timeSigDe;
    }

    public void setTimeSigDe(int timeSigDe) {
        this.timeSigDe = timeSigDe;
    }

    public int getTempoTick() {
        return tempoTick;
    }

    public void setTempoTick(int tempoTick) {
        this.tempoTick = tempoTick;
    }

    public int getTempoValue() {
        return tempoValue;
    }

    public void setTempoValue(int tempoValue) {
        this.tempoValue = tempoValue;
    }

    public Element toElement() {
        Element masterTrack = new BaseElement("masterTrack");
        Element e, e1;

        e = masterTrack.addElement("seqName");
        e.addCDATA(this.name);

        e = masterTrack.addElement("comment");
        e.addCDATA(this.comment);

        e = masterTrack.addElement("resolution");
        e.setText(String.valueOf(this.resolution));

        e = masterTrack.addElement("preMeasure");
        e.setText(String.valueOf(this.preMeasure));

        e = masterTrack.addElement("timeSig");
        e1 = e.addElement("m");
        e1.setText(String.valueOf(this.timeSigM));
        e1 = e.addElement("nu");
        e1.setText(String.valueOf(this.timeSigNu));
        e1 = e.addElement("de");
        e1.setText(String.valueOf(this.timeSigDe));

        e = masterTrack.addElement("tempo");
        e1 = e.addElement("t");
        e1.setText(String.valueOf(this.tempoTick));
        e1 = e.addElement("v");
        e1.setText(String.valueOf(this.tempoValue));

        return masterTrack;
    }
}
