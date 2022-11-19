package com.severle.entry.note;

import com.severle.entry.part.Style;
import com.severle.util.ToElement;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

import java.util.List;

public class NoteStyle extends Style implements ToElement {
    private int vibLen;

    private int vibType;

    public NoteStyle(int accent, int bendDep, int bendLen, int decay, int fallPort, int opening, int risePort, int vibLen, int vibType) {
        super(accent, bendDep, bendLen, decay, fallPort, opening, risePort);
        this.vibLen = vibLen;
        this.vibType = vibType;
    }

    public NoteStyle(NoteStyle style) {
        super(style);
        this.vibLen = style.getVibLen();
        this.vibType = style.getVibType();
    }

    public NoteStyle(Element nStyle) {
        super(nStyle);
        List<Element> list = nStyle.elements("v");

        for (Element e : list) {
            switch (e.attributeValue("id")) {
                case "vibLen" : {
                    this.vibLen = Integer.parseInt(e.getText());
                    break;
                }
                case "vibType" : {
                    this.vibType = Integer.parseInt(e.getText());
                    break;
                }
                default : {
                    break;
                }
            }
        }
    }

    public NoteStyle() {
    }

    public int getVibLen() {
        return vibLen;
    }

    public void setVibLen(int vibLen) {
        this.vibLen = vibLen;
    }

    public int getVibType() {
        return vibType;
    }

    public void setVibType(int vibType) {
        this.vibType = vibType;
    }

    @Override
    public Element toElement() {
        Element nStyle = new BaseElement("nStyle");
        Element e;

        e = nStyle.addElement("v");
        e.addAttribute("id", "accent");
        e.setText(String.valueOf(this.getAccent()));

        e = nStyle.addElement("v");
        e.addAttribute("id", "bendDep");
        e.setText(String.valueOf(this.getBendDep()));

        e = nStyle.addElement("v");
        e.addAttribute("id", "bendLen");
        e.setText(String.valueOf(this.getBendLen()));

        e = nStyle.addElement("v");
        e.addAttribute("id", "decay");
        e.setText(String.valueOf(this.getDecay()));

        e = nStyle.addElement("v");
        e.addAttribute("id", "fallPort");
        e.setText(String.valueOf(this.getFallPort()));

        e = nStyle.addElement("v");
        e.addAttribute("id", "opening");
        e.setText(String.valueOf(this.getOpening()));

        e = nStyle.addElement("v");
        e.addAttribute("id", "risePort");
        e.setText(String.valueOf(this.getRisePort()));

        e = nStyle.addElement("v");
        e.addAttribute("id", "vibLen");
        e.setText(String.valueOf(this.vibLen));

        e = nStyle.addElement("v");
        e.addAttribute("id", "vibType");
        e.setText(String.valueOf(this.vibType));

        return nStyle;
    }
}
