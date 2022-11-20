package com.severle.entity.mixer;

import com.severle.util.ToElement;
import org.dom4j.Element;

public abstract class Unit implements ToElement {
    private int id;

    private int gin;

    private int sendLevel;

    private boolean send;

    private boolean mute;

    private boolean solo;

    private int pan;

    private int vol;

    public Unit(int id, int gin, int sendLevel, boolean send, boolean mute, boolean solo, int pan, int vol) {
        this.id = id;
        this.gin = gin;
        this.sendLevel = sendLevel;
        this.send = send;
        this.mute = mute;
        this.solo = solo;
        this.pan = pan;
        this.vol = vol;
    }

    public Unit(Unit unit) {
        this.id = unit.getId();
        this.gin = unit.getGin();
        this.sendLevel = unit.getSendLevel();
        this.send = unit.isSend();
        this.mute = unit.isMute();
        this.solo = unit.isSolo();
        this.pan = unit.getPan();
        this.vol = unit.getVol();
    }

    public Unit(Element unit) {

    }

    public Unit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGin() {
        return gin;
    }

    public void setGin(int gin) {
        this.gin = gin;
    }

    public int getSendLevel() {
        return sendLevel;
    }

    public void setSendLevel(int sendLevel) {
        this.sendLevel = sendLevel;
    }

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public boolean isSolo() {
        return solo;
    }

    public void setSolo(boolean solo) {
        this.solo = solo;
    }

    public int getPan() {
        return pan;
    }

    public void setPan(int pan) {
        this.pan = pan;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }
}
