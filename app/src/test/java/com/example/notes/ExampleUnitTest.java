package com.example.notes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void notesContractCreateTable() {
        assertEquals("CREATE TABLE IF NOT EXISTS notes " +
                        "( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "title TEXT, description TEXT, " +
                        "day_of_week INTEGER, " +
                        "priority INTEGER )",
                NotesContract.NotesEntry.createTable());
    }

    @Test
    public void notesContractDropTable() {
        assertEquals("DROP TABLE IF EXISTS notes", NotesContract.NotesEntry.dropTable());
    }
}