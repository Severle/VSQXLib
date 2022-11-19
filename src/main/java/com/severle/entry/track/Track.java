package com.severle.entry.track;

import com.severle.service.PartList;
import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

import java.util.List;

public class Track implements ToElement {
    private int no;

    private String name;

    private String comment;

    private PartList partList;

    {
        this.partList = new PartList();
    }

    public Track(int no, String name, String comment, PartList partList) {
        this.no = no;
        this.name = name;
        this.comment = comment;
        this.partList = partList;
    }

    public Track(Track track) {
        this.no = track.getNo();
        this.name = track.getName();
        this.comment = track.getComment();
        this.partList = new PartList(track.partList);
    }

    public Track(Element vsTrack) {
        this.no = Integer.parseInt(vsTrack.elementText("tNo"));
        this.name = vsTrack.elementText("name");
        this.comment = vsTrack.elementText("comment");
        List<Element> parts = vsTrack.elements("vsPart");
        this.partList = new PartList(parts, "");
    }

    public Track() {

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    public PartList getPartList() {
        return partList;
    }

    public void setPartList(PartList partList) {
        this.partList = partList;
    }

    public Element toElement() {
        Element vsTrack = new BaseElement("vsTrack");
        Element e;

        e = vsTrack.addElement("tNo");
        e.setText(String.valueOf(this.no));

        e = vsTrack.addElement("name");
        e.addCDATA(this.name);

        e = vsTrack.addElement("comment");
        e.addCDATA(this.comment);

        for (Element element : this.partList.toElement()) {
            vsTrack.add(element);
        }

        return vsTrack;
    }
}
