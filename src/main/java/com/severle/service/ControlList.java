package com.severle.service;

import com.severle.entity.parameter.ControlPoint;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControlList {
    private List<ControlPoint> BRE;
    private List<ControlPoint> BRI;
    private List<ControlPoint> CLE;
    private List<ControlPoint> DYN;
    private List<ControlPoint> GEN;
    private List<ControlPoint> GWL;
    private List<ControlPoint> PBS;
    private List<ControlPoint> PIT;
    private List<ControlPoint> POR;
    private List<ControlPoint> XSY;

    {
        this.BRE = new ArrayList<>();
        this.BRI = new ArrayList<>();
        this.CLE = new ArrayList<>();
        this.DYN = new ArrayList<>();
        this.GEN = new ArrayList<>();
        this.GWL = new ArrayList<>();
        this.PBS = new ArrayList<>();
        this.PIT = new ArrayList<>();
        this.POR = new ArrayList<>();
        this.XSY = new ArrayList<>();
    }

    public ControlList(List<ControlPoint> BRE, List<ControlPoint> BRI, List<ControlPoint> CLE, List<ControlPoint> DYN, List<ControlPoint> GEN, List<ControlPoint> GWL, List<ControlPoint> PBS, List<ControlPoint> PIT, List<ControlPoint> POR, List<ControlPoint> XSY) {
        this.BRE = BRE;
        this.BRI = BRI;
        this.CLE = CLE;
        this.DYN = DYN;
        this.GEN = GEN;
        this.GWL = GWL;
        this.PBS = PBS;
        this.PIT = PIT;
        this.POR = POR;
        this.XSY = XSY;
    }

    public ControlList(ControlList controlList) {
        this.BRE = new ArrayList<>(controlList.getBRE());
        this.BRI = new ArrayList<>(controlList.getBRI());
        this.CLE = new ArrayList<>(controlList.getCLE());
        this.DYN = new ArrayList<>(controlList.getDYN());
        this.GEN = new ArrayList<>(controlList.getGEN());
        this.GWL = new ArrayList<>(controlList.getGWL());
        this.PBS = new ArrayList<>(controlList.getPBS());
        this.PIT = new ArrayList<>(controlList.getPIT());
        this.POR = new ArrayList<>(controlList.getPOR());
        this.XSY = new ArrayList<>(controlList.getXSY());
    }

    public ControlList(List<Element> ccs) {
        List<ControlPoint> list = new ArrayList<>();
        for (Element e : ccs) {
            list.add(new ControlPoint(e));
        }
        for (ControlPoint point : list) {
            this.addControlPoint(point);
        }
    }

    public ControlList() {
    }

    public List<ControlPoint> getBRE() {
        return BRE;
    }

    public void setBRE(List<ControlPoint> BRE) {
        this.BRE = BRE;
    }

    public List<ControlPoint> getBRI() {
        return BRI;
    }

    public void setBRI(List<ControlPoint> BRI) {
        this.BRI = BRI;
    }

    public List<ControlPoint> getCLE() {
        return CLE;
    }

    public void setCLE(List<ControlPoint> CLE) {
        this.CLE = CLE;
    }

    public List<ControlPoint> getDYN() {
        return DYN;
    }

    public void setDYN(List<ControlPoint> DYN) {
        this.DYN = DYN;
    }

    public List<ControlPoint> getGEN() {
        return GEN;
    }

    public void setGEN(List<ControlPoint> GEN) {
        this.GEN = GEN;
    }

    public List<ControlPoint> getGWL() {
        return GWL;
    }

    public void setGWL(List<ControlPoint> GWL) {
        this.GWL = GWL;
    }

    public List<ControlPoint> getPBS() {
        return PBS;
    }

    public void setPBS(List<ControlPoint> PBS) {
        this.PBS = PBS;
    }

    public List<ControlPoint> getPIT() {
        return PIT;
    }

    public void setPIT(List<ControlPoint> PIT) {
        this.PIT = PIT;
    }

    public List<ControlPoint> getPOR() {
        return POR;
    }

    public void setPOR(List<ControlPoint> POR) {
        this.POR = POR;
    }

    public List<ControlPoint> getXSY() {
        return XSY;
    }

    public void setXSY(List<ControlPoint> XSY) {
        this.XSY = XSY;
    }

    public void addBRE(ControlPoint point) {
        this.BRE.add(point);
        Collections.sort(this.BRE);
    }

    public void removeBRE(int index) {
        this.BRE.remove(index);
    }

    public void removeBRE(ControlPoint point) {
        this.BRE.remove(point);
    }

    public void addBRI(ControlPoint point) {
        this.BRI.add(point);
        Collections.sort(this.BRI);
    }

    public void removeBRI(int index) {
        this.BRI.remove(index);
    }

    public void removeBRI(ControlPoint point) {
        this.BRI.remove(point);
    }

    public void addCLE(ControlPoint point) {
        this.CLE.add(point);
        Collections.sort(this.CLE);
    }

    public void removeCLE(int index) {
        this.CLE.remove(index);
    }

    public void removeCLE(ControlPoint point) {
        this.CLE.remove(point);
    }

    public void addDYN(ControlPoint point) {
        this.DYN.add(point);
        Collections.sort(this.DYN);
    }

    public void removeDYN(int index) {
        this.DYN.remove(index);
    }

    public void removeDYN(ControlPoint point) {
        this.DYN.remove(point);
    }

    public void addGEN(ControlPoint point) {
        this.GEN.add(point);
        Collections.sort(this.GEN);
    }

    public void removeGEN(int index) {
        this.GEN.remove(index);
    }

    public void removeGEN(ControlPoint point) {
        this.GEN.remove(point);
    }

    public void addGWL(ControlPoint point) {
        this.GWL.add(point);
        Collections.sort(this.GWL);
    }

    public void removeGWL(int index) {
        this.GWL.remove(index);
    }

    public void removeGWL(ControlPoint point) {
        this.GWL.remove(point);
    }

    public void addPBS(ControlPoint point) {
        this.PBS.add(point);
        Collections.sort(this.PBS);
    }

    public void removePBS(int index) {
        this.PBS.remove(index);
    }

    public void removePBS(ControlPoint point) {
        this.PBS.remove(point);
    }

    public void addPIT(ControlPoint point) {
        this.PIT.add(point);
        Collections.sort(this.PIT);
    }

    public void removePIT(int index) {
        this.PIT.remove(index);
    }

    public void removePIT(ControlPoint point) {
        this.PIT.remove(point);
    }

    public void addPOR(ControlPoint point) {
        this.POR.add(point);
        Collections.sort(this.POR);
    }

    public void removePOR(int index) {
        this.POR.remove(index);
    }

    public void removePOR(ControlPoint point) {
        this.POR.remove(point);
    }

    public void addXSY(ControlPoint point) {
        this.XSY.add(point);
        Collections.sort(this.XSY);
    }

    public void removeXSY(int index) {
        this.XSY.remove(index);
    }

    public void removeXSY(ControlPoint point) {
        this.XSY.remove(point);
    }

    public void addControlPoint(ControlPoint cc) {
        switch (cc.getType()) {
            case BRE: {
                this.addBRE(cc);
                break;
            }
            case BRI: {
                this.addBRI(cc);
                break;
            }
            case CLE: {
                this.addCLE(cc);
                break;
            }
            case DYN: {
                this.addDYN(cc);
                break;
            }
            case GEN: {
                this.addGEN(cc);
                break;
            }
            case GWL: {
                this.addGWL(cc);
                break;
            }
            case PBS: {
                this.addPBS(cc);
                break;
            }
            case PIT: {
                this.addPIT(cc);
                break;
            }
            case POR: {
                this.addPOR(cc);
                break;
            }
            case XSY: {
                this.addXSY(cc);
                break;
            }
            default: {
                break;
            }
        }
    }

    public void removeControlPoint(ControlPoint cc) {
        switch (cc.getType()) {
            case BRE: {
                this.removeBRE(cc);
                break;
            }
            case BRI: {
                this.removeBRI(cc);
                break;
            }
            case CLE: {
                this.removeCLE(cc);
                break;
            }
            case DYN: {
                this.removeDYN(cc);
                break;
            }
            case GEN: {
                this.removeGEN(cc);
                break;
            }
            case GWL: {
                this.removeGWL(cc);
                break;
            }
            case PBS: {
                this.removePBS(cc);
                break;
            }
            case PIT: {
                this.removePIT(cc);
                break;
            }
            case POR: {
                this.removePOR(cc);
                break;
            }
            case XSY: {
                this.removeXSY(cc);
                break;
            }
            default: {
                break;
            }
        }
    }

    public List<Element> toElement() {
        List<Element> list = new ArrayList<>();

        List<ControlPoint> points = new ArrayList<>();

        points.addAll(this.BRE);
        points.addAll(this.BRI);
        points.addAll(this.CLE);
        points.addAll(this.DYN);
        points.addAll(this.GEN);
        points.addAll(this.GWL);
        points.addAll(this.PBS);
        points.addAll(this.PIT);
        points.addAll(this.POR);
        points.addAll(this.XSY);

        Collections.sort(points);

        for (ControlPoint point : points) {
            list.add(point.toElement());
        }

        return list;
    }
}
