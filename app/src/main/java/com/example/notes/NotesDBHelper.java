package com.example.notes;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class NotesDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "note";
    public static final int VERSION = 1;

    public NotesDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NotesContract.NotesEntry.createTable());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(NotesContract.NotesEntry.dropTable());
        onCreate(db);
    }

    public void writeNotesDB(Note... notes) {

        SQLiteDatabase db = getWritableDatabase();

        for (Note note : notes) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE, note.getTitle());
            contentValues.put(NotesContract.NotesEntry.COLUMN_DESCRIPTION, note.getDescription());
            contentValues.put(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK, DayOfWeek.getId(note.getDayOfWeek()));
            contentValues.put(NotesContract.NotesEntry.COLUMN_PRIORITY, note.getPriority().getId());


            db.insert(NotesContract.NotesEntry.TABLE_NAME, null, contentValues);
        }

        db.close();
    }

    public List<Note> readNotesDB() {

        List<Note> notes = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(NotesContract.NotesEntry.TABLE_NAME,
                null, null, null, null, null, null);

        int indexId = cursor.getColumnIndex(NotesContract.NotesEntry._ID);
        int indexTitle = cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_TITLE);
        int indexDescription = cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_DESCRIPTION);
        int indexDay = cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK);
        int indexPriority = cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_PRIORITY);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(indexId);
            String title = cursor.getString(indexTitle);
            String description = cursor.getString(indexDescription);
            int day = cursor.getInt(indexDay);
            int priority = cursor.getInt(indexPriority);

            notes.add(new Note(id, title, description, DayOfWeek.values()[day], Priority.searchPriority(priority)));
        }

        return notes;
    }

    public void removeNoteDBFromId(int id) {

        @SuppressLint("DefaultLocale")
        String where = String.format("%s = ?", NotesContract.NotesEntry._ID);
        SQLiteDatabase db = getWritableDatabase();

        db.delete(NotesContract.NotesEntry.TABLE_NAME, where, new String[] {String.valueOf(id)});

        db.close();
    }

    public void updateNoteDBFromId(Note note) {

        @SuppressLint("DefaultLocale")
        String where = String.format("%s = ?", NotesContract.NotesEntry._ID);
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesContract.NotesEntry._ID, note.getId());
        contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE, note.getTitle());
        contentValues.put(NotesContract.NotesEntry.COLUMN_DESCRIPTION, note.getDescription());
        contentValues.put(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK, DayOfWeek.getId(note.getDayOfWeek()));
        contentValues.put(NotesContract.NotesEntry.COLUMN_PRIORITY, note.getPriority().getId());

        db.update(NotesContract.NotesEntry.TABLE_NAME, contentValues, where, new String[] {String.valueOf(note.getId())});

        db.close();
    }
}
