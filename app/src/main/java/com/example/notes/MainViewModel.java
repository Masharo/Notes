package com.example.notes;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.Objects;

public class MainViewModel extends AndroidViewModel {

    private static NotesDatabase database;
    private LiveData<List<Note>> notes;

    public MainViewModel(@NonNull Application application) {
        super(application);

        database = NotesDatabase.getInstance(getApplication());
        notes = database.getNotesDao().getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return notes;
    }

    public void insertNote(@NonNull Note note) {
        new InsertTask().execute(note);
    }

    public void deleteNote(@NonNull Note note) {
        new DeleteTask().execute(note);
    }

    public void deleteAllNote() {
        new DeleteAllTask().execute();
    }

    public void updateNote(@NonNull Note note) {
        new UpdateNote().execute(note);
    }

    private static boolean validAsyncTask(Note... notes) {
        return Objects.nonNull(notes) && notes.length > 0;
    }

    private static class InsertTask extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... notes) {
            if (validAsyncTask(notes)) {
                database.getNotesDao().insertNote(notes[0]);
            }

            return null;
        }
    }

    private static class DeleteTask extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... notes) {
            if (validAsyncTask(notes)) {
                database.getNotesDao().deleteNote(notes[0]);
            }

            return null;
        }
    }

    private static class DeleteAllTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            if (validAsyncTask()) {
                database.getNotesDao().deleteAllNotes();
            }

            return null;
        }
    }

    private static class UpdateNote extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... notes) {

            if (validAsyncTask(notes)) {
                database.getNotesDao().updateNote(notes[0]);
            }

            return null;
        }
    }
}
