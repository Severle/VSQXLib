package com.severle.entity.part;

import com.severle.other.V2Plug;
import com.severle.service.ControlList;
import com.severle.service.NoteList;
import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

import java.util.List;

public class Part implements ToElement, Comparable<Part> {
    private int tick;

    private int playTime;

    private String name;

    private String comment;

    private boolean isV2Compatible;

    private Style partStyle;

    private PartSinger singer;

    private ControlList ccList;

    private NoteList noteList;

    public Part(int tick, int playTime, String name, String comment, boolean isV2Compatible, Style partStyle, PartSinger singer, ControlList ccList, NoteList noteList) {
        this.tick = tick;
        this.playTime = playTime;
        this.name = name;
        this.comment = comment;
        this.isV2Compatible = isV2Compatible;
        this.partStyle = partStyle;
        this.singer = singer;
        this.ccList = ccList;
        this.noteList = noteList;
    }

    public Part(Part part) {
        this.tick = part.getTick();
        this.playTime = part.getPlayTime();
        this.name = part.getName();
        this.comment = part.getComment();
        this.isV2Compatible = part.isV2Compatible();
        this.partStyle = part.getPartStyle();
        this.singer = part.getSinger();
        this.ccList = part.getCcList();
        this.noteList = part.getNoteList();
    }

    public Part(Element vsPart) {
        this.tick = Integer.parseInt(vsPart.elementText("t"));
        this.playTime = Integer.parseInt(vsPart.elementText("playTime"));
        this.name = vsPart.elementText("name");
        this.comment = vsPart.elementText("comment");
        this.isV2Compatible = vsPart.element("sPlug") != null;

        this.partStyle = new Style(vsPart.element("pStyle"));
        this.singer = new PartSinger(vsPart.element("singer"));
        List<Element> ccs = vsPart.elements("cc");
        List<Element> notes = vsPart.elements("note");
        this.ccList = new ControlList(ccs);
        this.noteList = new NoteList(notes, "");
    }

    public Part() {
        this.partStyle = new Style();
        this.singer = new PartSinger();
        this.ccList = new ControlList();
        this.noteList = new NoteList();
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
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

    public boolean isV2Compatible() {
        return isV2Compatible;
    }

    public void setV2Compatible(boolean v2Compatible) {
        isV2Compatible = v2Compatible;
    }

    public Style getPartStyle() {
        return partStyle;
    }

    public void setPartStyle(Style partStyle) {
        this.partStyle = partStyle;
    }

    public PartSinger getSinger() {
        return singer;
    }

    public void setSinger(PartSinger singer) {
        this.singer = singer;
    }

    public ControlList getCcList() {
        return ccList;
    }

    public void setCcList(ControlList ccList) {
        this.ccList = ccList;
    }

    public NoteList getNoteList() {
        return noteList;
    }

    public void setNoteList(NoteList noteList) {
        this.noteList = noteList;
    }
    
    public Element toElement() {
        Element vsPart = new BaseElement("vsPart");
        Element e;
        
        e = vsPart.addElement("t");
        e.setText(String.valueOf(this.tick));
        
        e = vsPart.addElement("playTime");
        e.setText(String.valueOf(this.playTime));
        
        e = vsPart.addElement("name");
        e.addCDATA(this.name);
        
        e = vsPart.addElement("comment");
        e.addCDATA(this.comment);
        
        if (this.isV2Compatible) {
            vsPart.add(V2Plug.toElement());
        }
        
        vsPart.add(this.partStyle.toElement());
        
        vsPart.add(this.singer.toElement());

        for (Element element : this.ccList.toElement()) {
            vsPart.add(element);
        }

        for (Element element : this.noteList.toElement()) {
            vsPart.add(element);
        }

        e = vsPart.addElement("plane");
        e.setText("0");

        return vsPart;
    }

    @Override
    public int compareTo(Part p) {
        return this.tick - p.getTick();
    }
}
