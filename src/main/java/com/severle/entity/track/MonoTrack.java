package com.severle.entity.track;

import com.severle.util.ToElement;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

public class MonoTrack implements ToElement {

    public MonoTrack() {
    }

    @Override
    public Element toElement() {

        return new BaseElement("monoTrack");
    }
}
