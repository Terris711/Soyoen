package com.example.fragments_week4;

import androidx.lifecycle.ViewModel;

public class NoteViewModel extends ViewModel {
    private String noteTitle;
    private String noteDetails;
    private static boolean isNoteSaved;

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDetails() {
        return noteDetails;
    }

    public void setNoteDetails(String noteDetails) {
        this.noteDetails = noteDetails;
    }

    public static boolean isNoteSaved() {
        return isNoteSaved;
    }

    public void setNoteSaved(boolean noteSaved) {
        isNoteSaved = noteSaved;
    }
}
