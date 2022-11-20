package com.severle.service;

import com.severle.entity.track.Track;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackList {
    private List<Track> tracks;

    {
        this.tracks = new ArrayList<>();
    }

    public TrackList(List<Track> tracks) {
        this.tracks = tracks;
    }

    public TrackList(TrackList trackList) {
        this.tracks = new ArrayList<>(trackList.getTracks());
    }

    public TrackList(List<Element> tracks, String mark) {
        for (Element track : tracks) {
            this.addTrack(new Track(track));
        }
    }

    public TrackList() {
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
    }

    public Track getTrack(int index) {
        return this.tracks.get(index);
    }

    public void removeTrack(int index) {
        this.tracks.remove(index);
    }

    public List<Element> toElement() {
        List<Element> list = new ArrayList<>();
        Collections.sort(this.tracks);

        for (Track track : this.tracks) {
            list.add(track.toElement());
        }

        return list;
    }
}
