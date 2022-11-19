package com.severle.writer;

import com.severle.VSQX;
import com.severle.other.Aux;
import com.severle.other.Vender;
import com.severle.other.Version;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;

import java.io.FileWriter;
import java.io.IOException;

public class Vsq4Writer {

    public static void write(VSQX vsqx, String filePath) throws IOException {
        Document root = DocumentHelper.createDocument();
        Element vsq4 = root.addElement("vsq4", "http://www.yamaha.co.jp/vocaloid/schema/vsq4/");

        Header.addVSQXNamespace(vsq4);

        vsq4.add(Vender.toElement());

        vsq4.add(Version.toElement());

        vsq4.add(vsqx.getVoiceTable().toElement());

        vsq4.add(vsqx.getMixer().toElement());

        vsq4.add(vsqx.getMasterTrack().toElement());

        for (Element element : vsqx.getTracks().toElement()) {
            vsq4.add(element);
        }

        vsq4.add(vsqx.getMonoTrack().toElement());

        vsq4.add(vsqx.getStTrack().toElement());

        vsq4.add(Aux.toElement());

        FileWriter fileWriter = new FileWriter(filePath);
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setIndent("\t");
        outputFormat.setExpandEmptyElements(true);
        NewXMLWriter writer = new NewXMLWriter(fileWriter, outputFormat);

        writer.write(root);

        writer.close();
        fileWriter.close();
    }
}
