package com.severle.service;

import com.severle.entity.note.Note;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

public class NoteList {
    private List<Note> notes;

    {
        this.notes = new ArrayList<>();
    }

    public NoteList(List<Note> notes) {
        this.notes = notes;
    }

    public NoteList(NoteList noteList) {
        this.notes = new ArrayList<>(noteList.getNotes());
    }

    public NoteList(List<Element> notes, String mark) {
        for (Element note : notes) {
            this.addNote(new Note(note));
        }
    }

    public NoteList() {
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public void removeNote(int index) {
        this.notes.remove(index);
    }

    public void removeNote(Note note) {
        this.notes.remove(note);
    }

    public List<Element> toElement() {
        List<Element> list = new ArrayList<>();

        for (Note n : this.notes) {
            list.add(n.toElement());
        }

        return list;
    }
}
