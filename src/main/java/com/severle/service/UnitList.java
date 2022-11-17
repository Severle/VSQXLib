package com.severle.service;

import com.severle.entry.mixer.VsUnit;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

public class UnitList {

    private List<VsUnit> vsUnits;

    {
        this.vsUnits = new ArrayList<>();
    }

    public UnitList(List<VsUnit> vsUnits) {
        this.vsUnits = vsUnits;
    }

    public UnitList(UnitList unitList) {
        this.vsUnits = new ArrayList<>(unitList.getVsUnits());
    }

    public UnitList() {
    }

    public List<VsUnit> getVsUnits() {
        return vsUnits;
    }

    public void setVsUnits(List<VsUnit> vsUnits) {
        this.vsUnits = vsUnits;
    }

    public void addVsUnit(VsUnit unit) {
        this.vsUnits.add(unit);
    }

    public VsUnit getVsUnit(int index) {
        return this.vsUnits.get(index);
    }

    public void removeUnit(int index) {
        this.vsUnits.remove(index);
    }

    public int vsUnitNumber() {
        return this.vsUnits.size();
    }

    public List<Element> toElement() {
        List<Element> list = new ArrayList<>();

        for (VsUnit unit : this.vsUnits) {
            list.add(unit.toElement());
        }

        return list;
    }
}
