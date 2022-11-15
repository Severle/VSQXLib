package com.severle.service;

import com.severle.entry.singer.Singer;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

public class SingerList {
    private List<Singer> singers;

    {
        this.singers = new ArrayList<>();
    }

    public SingerList(List<Singer> singers) {
        this.singers = singers;
    }

    public SingerList(SingerList singerList) {
        this.singers = new ArrayList<>(singerList.getSingers());
    }

    public SingerList() {
    }

    public List<Singer> getSingers() {
        return singers;
    }

    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }


    public List<Element> toElement() {
        List<Element> list = new ArrayList<>();

        for (Singer s : this.singers) {
            list.add(s.toElement());
        }

        return list;
    }
}
