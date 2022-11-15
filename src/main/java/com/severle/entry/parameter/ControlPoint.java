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