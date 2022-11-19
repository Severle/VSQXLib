package com.severle.entry.parameter;

import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class ControlPoint implements Comparable<ControlPoint>, ToElement {
    private int tick;

    private int value;

    private Parameter type;

    public ControlPoint(int tick, int value, Parameter type) {
        this.tick = tick;
        this.value = value;
        this.type = type;
    }

    public ControlPoint(ControlPoint controlPoint) {
        this.tick = controlPoint.getTick();
        this.value = controlPoint.getValue();
        this.type = controlPoint.getType();
    }

    public ControlPoint(Element cc) {
        this.tick = Integer.parseInt(cc.elementText("t"));
        Element v = cc.element("v");
        switch (v.attributeValue("id")) {
            case "B" : {
                this.type = Parameter.BRE;
                break;
            }
            case "R" : {
                this.type = Parameter.BRI;
                break;
            }
            case "C" : {
                this.type = Parameter.CLE;
                break;
            }
            case "D" : {
                this.type = Parameter.DYN;
                break;
            }
            case "G" : {
                this.type = Parameter.GEN;
                break;
            }
            case "W" : {
                this.type = Parameter.GWL;
                break;
            }
            case "S" : {
                this.type = Parameter.PBS;
                break;
            }
            case "P" : {
                this.type = Parameter.PIT;
                break;
            }
            case "T" : {
                this.type = Parameter.POR;
                break;
            }
            case "X" : {
                this.type = Parameter.XSY;
                break;
            }
        }
        this.value = Integer.parseInt(v.getText());
    }

    public ControlPoint() {
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Parameter getType() {
        return type;
    }

    public void setType(Parameter type) {
        this.type = type;
    }

    public Element toElement() {
        Element cc = new BaseElement("cc");
        Element e;

        e = cc.addElement("t");
        e.setText(String.valueOf(this.tick));

        e = cc.addElement("v");
        e.addAttribute("id", this.type.getType());
        e.setText(String.valueOf(this.value));

        return cc;
    }

    @Override
    public int compareTo(ControlPoint p) {
        return this.tick - p.getTick();
    }
}