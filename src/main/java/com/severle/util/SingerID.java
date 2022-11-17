package com.severle.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingerID {
    private final Map<String, String> map;

    public SingerID() {
        this.map = new HashMap<>();
        SAXReader reader = new SAXReader();
        Document root;
        try {
            root = reader.read("src/main/resources/singerList.xml");
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

        Element singers = root.getRootElement();

        for (Object element : singers.elements("singer")) {
            this.map.put(((Element) element).attributeValue("name"),
                    ((Element) element).attributeValue("id"));
        }

    }

    public String getIDByName(String name) throws Exception {
        for (Map.Entry<String, String> entry : this.map.entrySet()) {
            if (name.equals(entry.getKey()))
                return entry.getValue();
        }
        throw new Exception("Unknown Singer Name,Can't find this name in the dictionary");
    }

    public String getNameByID(String id) throws Exception {
        for (Map.Entry<String, String> entry : this.map.entrySet()) {
            if (id.equals(entry.getValue()))
                return entry.getKey();
        }
        throw new Exception("Unknown Singer Name,Can't find this ID in the dictionary");
    }
}
