package com.severle.entry.part;

import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

import java.util.List;

public class Style implements ToElement {
    private int accent;

    private int bendDep;

    private int bendLen;

    private int decay;

    private int fallPort;

    private int opening;

    private int risePort;

    public Style(int accent, int bendDep, int bendLen, int decay, int fallPort, int opening, int risePort) {
        this.accent = accent;
        this.bendDep = bendDep;
        this.bendLen = bendLen;
        this.decay = decay;
        this.fallPort = fallPort;
        this.opening = opening;
        this.risePort = risePort;
    }

    public Style(Style style) {
        this.accent = style.getAccent();
        this.bendDep = style.getBendDep();
        this.bendLen = style.getBendLen();
        this.decay = style.getDecay();
        this.fallPort = style.getFallPort();
        this.opening = style.getOpening();
        this.risePort = style.getRisePort();
    }

    public Style(Element pStyle) {
        List<Element> list = pStyle.elements("v");

        for (Element e : list) {
            switch (e.attributeValue("id")) {
                case "accent" : {
                    this.accent = Integer.parseInt(e.getText());
                    break;
                }
                case "bendDep" : {
                    this.bendDep = Integer.parseInt(e.getText());
                    break;
                }
                case "bendLen" : {
                    this.bendLen = Integer.parseInt(e.getText());
                    break;
                }
                case "decay" : {
                    this.decay = Integer.parseInt(e.getText());
                    break;
                }
                case "fallPort" : {
                    this.fallPort = Integer.parseInt(e.getText());
                    break;
                }
                case "opening" : {
                    this.opening = Integer.parseInt(e.getText());
                    break;
                }
                case "risePort" : {
                    this.risePort = Integer.parseInt(e.getText());
                    break;
                }
                default : {
                    break;
                }
            }
        }
    }

    public Style() {
    }

    public int getAccent() {
        return accent;
    }

    public void setAccent(int accent) {
        this.accent = accent;
    }

    public int getBendDep() {
        return bendDep;
    }

    public void setBendDep(int bendDep) {
        this.bendDep = bendDep;
    }

    public int getBendLen() {
        return bendLen;
    }

    public void setBendLen(int bendLen) {
        this.bendLen = bendLen;
    }

    public int getDecay() {
        return decay;
    }

    public void setDecay(int decay) {
        this.decay = decay;
    }

    public int getFallPort() {
        return fallPort;
    }

    public void setFallPort(int fallPort) {
        this.fallPort = fallPort;
    }

    public int getOpening() {
        return opening;
    }

    public void setOpening(int opening) {
        this.opening = opening;
    }

    public int getRisePort() {
        return risePort;
    }

    public void setRisePort(int risePort) {
        this.risePort = risePort;
    }


    public Element toElement() {
        Element pStyle = new BaseElement("pStyle");
        Element e;

        e = pStyle.addElement("v");
        e.addAttribute("id", "accent");
        e.setText(String.valueOf(this.accent));

        e = pStyle.addElement("v");
        e.addAttribute("id", "bendDep");
        e.setText(String.valueOf(this.bendDep));

        e = pStyle.addElement("v");
        e.addAttribute("id", "bendLen");
        e.setText(String.valueOf(this.bendLen));

        e = pStyle.addElement("v");
        e.addAttribute("id", "decay");
        e.setText(String.valueOf(this.decay));

        e = pStyle.addElement("v");
        e.addAttribute("id", "fallPort");
        e.setText(String.valueOf(this.fallPort));

        e = pStyle.addElement("v");
        e.addAttribute("id", "opening");
        e.setText(String.valueOf(this.opening));

        e = pStyle.addElement("v");
        e.addAttribute("id", "risePort");
        e.setText(String.valueOf(this.risePort));

        return pStyle;
    }
}
