package com.severle.entry.voiceTable;

import com.severle.service.SingerList;
import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

import java.util.List;

public class VoiceTable implements ToElement {
    private SingerList singers;

    public VoiceTable(SingerList singers) {
        this.singers = singers;
    }

    public VoiceTable(VoiceTable voiceTable) {
        this.singers = voiceTable.getSingers();
    }

    public VoiceTable(Element vVoiceTable) {
        List<Element> voices = vVoiceTable.elements("vVoice");
        this.singers = new SingerList(voices, "");
    }

    public VoiceTable() {
        this.singers = new SingerList();
    }

    public SingerList getSingers() {
        return singers;
    }

    public void setSingers(SingerList singers) {
        this.singers = singers;
    }


    @Override
    public Element toElement() {
        Element vVoiceTable = new BaseElement("vVoiceTable");

        for (Element element : this.singers.toElement()) {
            vVoiceTable.add(element);
        }

        return vVoiceTable;
    }
}
