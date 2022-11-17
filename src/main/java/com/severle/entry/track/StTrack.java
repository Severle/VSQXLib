package com.severle.entry.track;

import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class StTrack implements ToElement {

    public StTrack() {
    }

    @Override
    public Element toElement() {
        return new BaseElement("stTrack");
    }
}
