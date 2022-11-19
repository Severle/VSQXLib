package com.severle.entry.note;

import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class Note implements ToElement {
    private int tick;

    private int during;

    private int nativePIT;

    private int vel;

    private String lyric;

    private String phoneme;

    private boolean lock;

    private NoteStyle style;

    public Note(int tick, int during, int nativePIT, int vel, String lyric, String phoneme, boolean lock, NoteStyle style) {
        this.tick = tick;
        this.during = during;
        this.nativePIT = nativePIT;
        this.vel = vel;
        this.lyric = lyric;
        this.phoneme = phoneme;
        this.lock = lock;
        this.style = style;
    }

    public Note(Note note) {
        this.tick = note.getTick();
        this.during = note.getDuring();
        this.nativePIT = note.getNativePIT();
        this.vel = note.getVel();
        this.lyric = note.getLyric();
        this.phoneme = note.getPhoneme();
        this.lock = note.isLock();
        this.style = new NoteStyle(note.getStyle());
    }

    public Note(Element note) {
        this.tick = Integer.parseInt(note.elementText("t"));
        this.during = Integer.parseInt(note.elementText("dur"));
        this.nativePIT = Integer.parseInt(note.elementText("n"));
        this.vel = Integer.parseInt(note.elementText("v"));
        this.lyric = note.elementText("y");

        Element p = note.element("p");

        this.lock = !p.attributeValue("lock").equals("0");

        this.phoneme = p.getText();
        this.style = new NoteStyle(note.element("nStyle"));
    }

    public Note() {
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public int getDuring() {
        return during;
    }

    public void setDuring(int during) {
        this.during = during;
    }

    public int getNativePIT() {
        return nativePIT;
    }

    public void setNativePIT(int nativePIT) {
        this.nativePIT = nativePIT;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public String getPhoneme() {
        return phoneme;
    }

    public void setPhoneme(String phoneme) {
        this.phoneme = phoneme;
    }

    public NoteStyle getStyle() {
        return style;
    }

    public void setStyle(NoteStyle style) {
        this.style = style;
    }

    public Element toElement() {
        Element note = new BaseElement("note");
        Element e;

        e = note.addElement("t");
        e.setText(String.valueOf(this.tick));

        e = note.addElement("dur");
        e.setText(String.valueOf(this.during));

        e = note.addElement("n");
        e.setText(String.valueOf(this.nativePIT));

        e = note.addElement("v");
        e.setText(String.valueOf(this.vel));

        e = note.addElement("y");
        e.addCDATA(this.lyric);

        e = note.addElement("p");
        if (this.lock) {
            e.addAttribute("lock", "1");
        }
        e.addAttribute("lock", "0");
        e.addCDATA(this.phoneme);

        note.add(this.style.toElement());

        return note;
    }
}
