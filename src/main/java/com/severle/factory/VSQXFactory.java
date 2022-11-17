package com.severle.factory;

import com.severle.VSQ4;
import com.severle.VSQX;
import com.severle.entry.mixer.*;
import com.severle.entry.singer.Singer;
import com.severle.entry.singer.SingerParameter;
import com.severle.entry.track.MasterTrack;
import com.severle.entry.voiceTable.VoiceTable;
import com.severle.util.SingerID;

public class VSQXFactory {
    public static VSQX getBlankVSQX() {
        VSQX vsqx = new VSQ4();

        vsqx.setVoiceTable(getDefaultVoiceTable());
        vsqx.setMixer(getDefaultMixer());
        vsqx.setMasterTrack(getDefaultMasterTrack());

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
}
