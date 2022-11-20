package com.severle;

import com.severle.entity.mixer.Mixer;
import com.severle.entity.note.Note;
import com.severle.entity.parameter.ControlPoint;
import com.severle.entity.part.Part;
import com.severle.entity.singer.Singer;
import com.severle.entity.track.MasterTrack;
import com.severle.entity.track.MonoTrack;
import com.severle.entity.track.StTrack;
import com.severle.entity.track.Track;
import com.severle.entity.voiceTable.VoiceTable;
import com.severle.service.TrackList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class VSQX {

    private Set<Singer> singerSet;
    private int trackNumber;


    private VoiceTable voiceTable;
    private Mixer mixer;
    private MasterTrack masterTrack;
    private TrackList tracks;
    private MonoTrack monoTrack;
    private StTrack stTrack;

    {
        this.singerSet = new HashSet<>();
        this.trackNumber = 0;

        this.voiceTable = new VoiceTable();
        this.mixer = new Mixer();
        this.masterTrack = new MasterTrack();
        this.tracks = new TrackList();
        this.monoTrack = new MonoTrack();
        this.stTrack = new StTrack();
    }

    public VSQX(Set<Singer> singerSet, int trackNumber, VoiceTable voiceTable, Mixer mixer, MasterTrack masterTrack, TrackList tracks, MonoTrack monoTrack, StTrack stTrack) {
        this.singerSet = singerSet;
        this.trackNumber = trackNumber;
        this.voiceTable = voiceTable;
        this.mixer = mixer;
        this.masterTrack = masterTrack;
        this.tracks = tracks;
        this.monoTrack = monoTrack;
        this.stTrack = stTrack;
    }

    public VSQX(VSQX vsqx) {
        this.singerSet = new HashSet<>(vsqx.getSingerSet());
        this.trackNumber = vsqx.getTrackNumber();
        this.voiceTable = new VoiceTable(vsqx.getVoiceTable());
        this.mixer = new Mixer(vsqx.getMixer());
        this.masterTrack = new MasterTrack(vsqx.getMasterTrack());
        this.tracks = new TrackList(vsqx.getTracks());
        this.monoTrack = new MonoTrack();
        this.stTrack = new StTrack();
    }

    public VSQX() {
    }

    public Set<Singer> getSingerSet() {
        return singerSet;
    }

    public void setSingerSet(Set<Singer> singerSet) {
        this.singerSet = singerSet;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public VoiceTable getVoiceTable() {
        return voiceTable;
    }

    public void setVoiceTable(VoiceTable voiceTable) {
        this.voiceTable = voiceTable;
    }

    public Mixer getMixer() {
        return mixer;
    }

    public void setMixer(Mixer mixer) {
        this.mixer = mixer;
    }

    public MasterTrack getMasterTrack() {
        return masterTrack;
    }

    public void setMasterTrack(MasterTrack masterTrack) {
        this.masterTrack = masterTrack;
    }

    public TrackList getTracks() {
        return tracks;
    }

    public void setTracks(TrackList tracks) {
        this.tracks = tracks;
    }

    public MonoTrack getMonoTrack() {
        return monoTrack;
    }

    public void setMonoTrack(MonoTrack monoTrack) {
        this.monoTrack = monoTrack;
    }

    public StTrack getStTrack() {
        return stTrack;
    }

    public void setStTrack(StTrack stTrack) {
        this.stTrack = stTrack;
    }

    public Track getTrack(int index) {
        return this.tracks.getTrack(index);
    }


    protected void numberAdd() {
        this.trackNumber++;
    }

    protected void numberMinus() {
        this.trackNumber--;
    }

    public void sortAll() {
        Collections.sort(this.mixer.getVsUnits().getVsUnits());
        Collections.sort(this.tracks.getTracks());
    }




    public abstract void addNewControlPoint(int trackIndex, int partIndex, ControlPoint point);

    public abstract void removeControlPoint(int trackIndex, int partIndex, ControlPoint point);

    public abstract void addNewNote(int trackIndex, int partIndex, Note note);

    public abstract void removeNote(int trackIndex, int partIndex, Note note);

    public abstract void addNewTrack(Track refTrack);

    public abstract void removeTrack(Track refTrack);

    public abstract void addNewPart(int trackIndex, Part refPart);

    public abstract void removePart(int trackIndex, Part refPart);

    public abstract void addNewSinger(String singerName);

    public abstract void setPartSinger(int trackIndex, int partIndex, Singer singer);
}
