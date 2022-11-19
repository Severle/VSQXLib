package com.severle.service;

import com.severle.entry.part.Part;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

public class PartList {
    private List<Part> list;

    {
        this.list = new ArrayList<>();
    }

    public PartList(List<Part> list) {
        this.list = list;
    }

    public PartList(PartList partList) {
        this.list = new ArrayList<>(partList.getList());
    }

    public PartList(List<Element> parts, String mark) {
        for (Element part : parts) {
            this.addPart(new Part(part));
        }
    }

    public PartList() {
    }

    public List<Part> getList() {
        return list;
    }

    public void setList(List<Part> list) {
        this.list = list;
    }

    public void addPart(Part part) {
        this.list.add(part);
    }

    public void removePart(int index) {
        this.list.remove(index);
    }

    public Part getPart(int index) {
        return this.list.get(index);
    }

    public List<Element> toElement() {
        List<Element> l = new ArrayList<>();

        for (Part part : this.list) {
            l.add(part.toElement());
        }

        return l;
    }
}
