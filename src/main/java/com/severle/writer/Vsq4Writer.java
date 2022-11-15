package com.severle.writer;

import com.severle.VSQX;
import com.severle.other.Aux;
import com.severle.other.Vender;
import com.severle.other.Version;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Vsq4Writer {
    private VSQX vsqx;

    public Vsq4Writer() {
    }

    public void write() {
        Document root = DocumentHelper.createDocument();
        Element vsq4 = root.addElement("vsq4", "http://www.yamaha.co.jp/vocaloid/schema/vsq4/");

        Header.addVSQXNamespace(vsq4);

        vsq4.add(Vender.toElement());

        vsq4.add(Version.toElement());








        vsq4.add(Aux.toElement());
    }
}
