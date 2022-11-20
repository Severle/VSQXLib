package com.severle.file.writer;

import org.dom4j.Element;

public class Header {
    public static void addVSQXNamespace(Element vsq4) {
        vsq4.addNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        vsq4.addAttribute("xsi:schemaLocation", "http://www.yamaha.co.jp/vocaloid/schema/vsq4/ vsq4.xsd");
    }
}
