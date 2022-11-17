package com.severle.factory;

import com.severle.VSQ4;
import com.severle.VSQX;
import com.severle.entry.mixer.*;
import com.severle.entry.part.Part;
import com.severle.entry.part.PartSinger;
import com.severle.entry.part.Style;
import com.severle.entry.singer.Singer;
import com.severle.entry.singer.SingerParameter;
import com.severle.entry.track.MasterTrack;
import com.severle.entry.track.Track;
import com.severle.entry.voiceTable.VoiceTable;
import com.severle.service.PartList;
import com.severle.service.TrackList;
import com.severle.util.SingerID;

public class VSQXFactory {
    public static VSQX getBlankDefaultVSQX() {
        VSQX vsqx = new VSQ4();

        vsqx.setVoiceTable(getDefaultVoiceTable());
        vsqx.setMixer(getDefaultMixer());
        vsqx.setMasterTrack(getDefaultMasterTrack());
        vsqx.setTracks(getDefaultTracks());

        return vsqx;
    }

    public static VoiceTable getDefaultVoiceTable() {
        VoiceTable voiceTable = new VoiceTable();

        voiceTable.getSingers().getSingers().add(getDefaultSinger("Luotianyi_CHN_Meng"));

        return voiceTable;
    }

    public static Singer getDefaultSinger(String singerName) {
        Singer singer = new Singer();
        SingerID singerID = new SingerID();

        singer.setBankSelected(4);
        singer.setProgramChange(0);
        try {
            singer.setId(singerID.getIDByName(singerName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        singer.setName(singerName);
        singer.setvPrm(new SingerParameter());

        return singer;
    }

    public static Mixer getDefaultMixer() {
        Mixer mixer = new Mixer();

        mixer.getVsUnits().addVsUnit(getDefaultVsUnit());
        mixer.setMonoUnit(getDefaultMonoUnit());

        return mixer;
    }

    public static MasterUnit getDefaultMasterUnit() {
        return new MasterUnit();
    }

    public static VsUnit getDefaultVsUnit() {
        VsUnit vsUnit = new VsUnit();

        vsUnit.setSendLevel(-898);
        vsUnit.setPan(64);

        return vsUnit;
    }

    public static MonoUnit getDefaultMonoUnit() {
        MonoUnit monoUnit = new MonoUnit();

        monoUnit.setSendLevel(-898);
        monoUnit.setPan(64);

        return monoUnit;
    }

    public static StUnit getDefaultUnit() {
        StUnit stUnit = new StUnit();

        stUnit.setVol(-129);

        return stUnit;
    }

    public static MasterTrack getDefaultMasterTrack() {
        MasterTrack masterTrack = new MasterTrack();

        masterTrack.setName("Default Settings");
        masterTrack.setComment("Default Settings");
        masterTrack.setResolution(480);
        masterTrack.setPreMeasure(4);

        masterTrack.setTimeSigM(0);
        masterTrack.setTimeSigNu(4);
        masterTrack.setTimeSigDe(4);

        masterTrack.setTempoTick(0);
        masterTrack.setTempoValue(12000);

        return masterTrack;
    }

    public static TrackList getDefaultTracks() {
        TrackList trackList = new TrackList();

        trackList.addTrack(getDefaultVsTrack());

        return trackList;
    }

    public static Track getDefaultVsTrack() {
        Track vsTrack = new Track();

        vsTrack.setNo(0);
        vsTrack.setName("Default Setting Track");
        vsTrack.setComment("Default Setting Track");
        vsTrack.setPartList(getDefaultPartList());

        return vsTrack;
    }

    public static PartList getDefaultPartList() {
        PartList partList = new PartList();

        partList.addPart(getDefaultVsPart());

        return partList;
    }

    public static Part getDefaultVsPart() {
        Part vsPart = new Part();

        vsPart.setTick(7680);
        vsPart.setPlayTime(61440);
        vsPart.setName("Default Part");
        vsPart.setComment("Default Setting Part");
        vsPart.setV2Compatible(true);
        vsPart.setPartStyle(getDefaultPartStyle());
        vsPart.setSinger(getDefaultPartSinger());

        return vsPart;
    }

    public static Style getDefaultPartStyle() {
        Style partStyle = new Style();

        partStyle.setAccent(100);
        partStyle.setBendDep(0);
        partStyle.setBendLen(0);
        partStyle.setDecay(0);
        partStyle.setFallPort(0);
        partStyle.setOpening(127);
        partStyle.setRisePort(0);

        return partStyle;
    }

    public static PartSinger getDefaultPartSinger() {
        PartSinger partSinger = new PartSinger();

        partSinger.setTick(0);
        partSinger.setBankSelected(4);
        partSinger.setProgramChange(0);

        return partSinger;
    }
}
