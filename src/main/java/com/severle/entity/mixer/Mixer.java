package com.severle.entity.mixer;

import com.severle.service.UnitList;
import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

import java.util.List;

public class Mixer implements ToElement {
    private MasterUnit masterUnit;

    private UnitList vsUnits;

    private MonoUnit monoUnit;

    private StUnit stUnit;

    public Mixer(MasterUnit masterUnit, UnitList vsUnits, MonoUnit monoUnit, StUnit stUnit) {
        this.masterUnit = masterUnit;
        this.vsUnits = vsUnits;
        this.monoUnit = monoUnit;
        this.stUnit = stUnit;
    }

    public Mixer(Mixer mixer) {
        this.masterUnit = mixer.getMasterUnit();
        this.vsUnits = mixer.getVsUnits();
        this.monoUnit = mixer.getMonoUnit();
        this.stUnit = mixer.getStUnit();
    }

    public Mixer(Element mixer) {
        this.masterUnit = new MasterUnit(mixer.element("masterUnit"));
        this.vsUnits = new UnitList();

        List<Element> units = mixer.elements("vsUnit");

        this.vsUnits = new UnitList(units, "");
        this.monoUnit = new MonoUnit(mixer.element("monoUnit"));
        this.stUnit = new StUnit(mixer.element("stUnit"));
    }

    public Mixer() {
        this.masterUnit = new MasterUnit();
        this.vsUnits = new UnitList();
        this.monoUnit = new MonoUnit();
        this.stUnit = new StUnit();
    }

    public MasterUnit getMasterUnit() {
        return masterUnit;
    }

    public void setMasterUnit(MasterUnit masterUnit) {
        this.masterUnit = masterUnit;
    }

    public UnitList getVsUnits() {
        return vsUnits;
    }

    public void setVsUnits(UnitList vsUnits) {
        this.vsUnits = vsUnits;
    }

    public MonoUnit getMonoUnit() {
        return monoUnit;
    }

    public void setMonoUnit(MonoUnit monoUnit) {
        this.monoUnit = monoUnit;
    }

    public StUnit getStUnit() {
        return stUnit;
    }

    public void setStUnit(StUnit stUnit) {
        this.stUnit = stUnit;
    }


    @Override
    public Element toElement() {
        Element mixer = new BaseElement("mixer");

        mixer.add(this.masterUnit.toElement());

        for (Element element : this.vsUnits.toElement()) {
            mixer.add(element);
        }

        mixer.add(this.monoUnit.toElement());

        mixer.add(this.stUnit.toElement());

        return mixer;
    }
}
