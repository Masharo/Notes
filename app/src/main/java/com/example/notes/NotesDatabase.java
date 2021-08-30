package com.example.notes;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.Objects;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {

    public static final String DB_NAME = "note_db";
    private static NotesDatabase database;

    public static synchronized NotesDatabase getInstance(Context context) {
        if (Objects.isNull(database)) {
            database = Room.databaseBuilder(context, NotesDatabase.class, DB_NAME).build();
        }

        return database;
    }

    public abstract NotesDao getNotesDao();
}
