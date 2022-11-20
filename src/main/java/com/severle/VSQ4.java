package com.severle;

import com.severle.entity.mixer.VsUnit;
import com.severle.entity.note.Note;
import com.severle.entity.parameter.ControlPoint;
import com.severle.entity.part.Part;
import com.severle.entity.part.PartSinger;
import com.severle.entity.singer.Singer;
import com.severle.entity.track.Track;
import com.severle.factory.VSQXFactory;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VSQ4 extends VSQX{

    @Override
    public void addNewControlPoint(int trackIndex, int partIndex, ControlPoint point) {
        this.getTrack(trackIndex).getPart(partIndex).getCcList().addControlPoint(point);
    }

    @Override
    public void removeControlPoint(int trackIndex, int partIndex, ControlPoint point) {
        this.getTrack(trackIndex).getPart(partIndex).getCcList().removeControlPoint(point);
    }

    @Override
    public void addNewNote(int trackIndex, int partIndex, Note note) {
        this.getTrack(trackIndex).getPart(partIndex).getNoteList().addNote(note);
    }

    @Override
    public void removeNote(int trackIndex, int partIndex, Note note) {
        this.getTrack(trackIndex).getPart(partIndex).getNoteList().removeNote(note);
    }

    @Override
    public void addNewTrack(Track refTrack) {
        Track track = new Track(refTrack);
        VsUnit vsUnit = VSQXFactory.getDefaultVsUnit();
        track.setNo(this.getTrackNumber() - 1);
        vsUnit.setId(this.getTrackNumber() - 1);
        this.numberAdd();
        this.getTracks().addTrack(track);
        this.getMixer().getVsUnits().addVsUnit(vsUnit);

        this.sortAll();
    }

    @Override
    public void removeTrack(Track refTrack) {
        int no = refTrack.getNo();

        List<Track> tracks = this.getTracks().getTracks();
        List<VsUnit> vsUnits = this.getMixer().getVsUnits().getVsUnits();
        this.sortAll();
        this.getTracks().removeTrack(no);
        this.getMixer().getVsUnits().removeUnit(no);
        this.sortAll();
        this.numberMinus();

        for (int i = no;i < this.getTrackNumber();i++) {
            tracks.get(i).setNo(tracks.get(i).getNo() - 1);
            vsUnits.get(i).setId(vsUnits.get(i).getId() - 1);
        }
    }

    @Override
    public void addNewPart(int trackIndex, Part refPart) {
        this.getTrack(trackIndex).getPartList().addPart(refPart);
    }

    @Override
    public void removePart(int trackIndex, Part refPart) {
        List<Part> parts = this.getTrack(trackIndex).getPartList().getList();
        Collections.sort(parts);
        int t = -1;

        for (int i = 0;i < parts.size();i++) {
            if (parts.get(i).getTick() == refPart.getTick()) {
                t = i;
                break;
            }
        }

        if (t != -1)
            this.getTrack(trackIndex).getPartList().removePart(t);
    }

    @Override
    public void addNewSinger(String singerName) {
        int pc = this.getSingerSet().size() - 1;
        Singer singer = VSQXFactory.getDefaultSinger(singerName);
        singer.setProgramChange(pc);
        this.getSingerSet().add(singer);
    }

    @Override
    public void setPartSinger(int trackIndex, int partIndex, Singer singer) {
        Iterator<Singer> it = this.getSingerSet().iterator();
        Singer s;
        while (it.hasNext()) {
            s = it.next();
            if (s.equals(singer)) {
                this.getTrack(trackIndex).getPart(partIndex).setSinger(new PartSinger(0, s.getBankSelected(), s.getProgramChange()));
                break;
            }
        }
    }
}
