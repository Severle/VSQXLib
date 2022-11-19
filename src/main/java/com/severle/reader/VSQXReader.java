package com.severle.reader;

import com.severle.VSQ4;
import com.severle.VSQX;
import com.severle.entry.mixer.Mixer;
import com.severle.entry.track.MasterTrack;
import com.severle.entry.voiceTable.VoiceTable;
import com.severle.service.TrackList;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class VSQXReader {
    public static VSQX read(InputStream in) {
        VSQX vsqx = new VSQ4();

        SAXReader saxReader = new SAXReader();
        Document read;
        try {
            read = saxReader.read(in);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        Element vsq4 = read.getRootElement();

        vsqx.setVoiceTable(new VoiceTable(vsq4.element("vVoiceTable")));
        vsqx.setMixer(new Mixer(vsq4.element("mixer")));
        vsqx.setMasterTrack(new MasterTrack(vsq4.element("masterTrack")));
        List<Element> vsTracks = vsq4.elements("vsTrack");
        vsqx.setTracks(new TrackList(vsTracks, ""));

        return vsqx;
    }

    public static VSQX read(String filePath) throws IOException {
        return read(Files.newInputStream(Paths.get(filePath)));
    }

    public static VSQX read(File file) throws IOException {
        return read(Files.newInputStream(file.toPath()));
    }
}
