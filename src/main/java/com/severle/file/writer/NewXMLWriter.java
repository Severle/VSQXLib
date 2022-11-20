package com.severle.file.writer;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.Attributes;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class NewXMLWriter extends XMLWriter {
    Field il;

    public NewXMLWriter(FileWriter out, OutputFormat format) {
        super(out, format);
        try {
            il = XMLWriter.class.getDeclaredField("indentLevel");
            il.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    int getIndentLevel() {
        try {
            return il.getInt(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void writeAttributes(Attributes attributes) throws IOException {
        int I = getIndentLevel();
        setIndentLevel(I + 1);
        super.writeAttributes(attributes);
        setIndentLevel(I);
    }

    @Override
    protected void writeAttribute(Attributes attributes, int index) throws IOException {
        writePrintln();
        indent();
        super.writeAttribute(attributes, index);
    }

    @Override
    protected void writeDeclaration() throws IOException {
        OutputFormat format = new OutputFormat();
        String encoding = format.getEncoding();
        if(!format.isSuppressDeclaration()) {
            writer.write("<?xml version=\"1.0\"");
            if (encoding.equals("UTF-8")) {
                if (!format.isOmitEncoding()) {
                    writer.write(" encoding=\"UTF-8\"");
                } else {
                    if (!format.isOmitEncoding()) {
                        writer.write(" encoding=\"" + encoding + "\"");
                    }
                }
            }
            writer.write(" standalone=\"no\"");
            writer.write("?>");
        }
    }
}
