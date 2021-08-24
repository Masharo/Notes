package com.example.notes;

import android.os.Build;
import android.provider.BaseColumns;

import androidx.annotation.RequiresApi;

public class NotesContract {

    public static final String TYPE_TEXT = "TEXT",
                               TYPE_INTEGER = "INTEGER";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS %s ( %s )";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS %s";

    public static String getRow(String column, String type) {
        return getRow(column, type, false, false);
    }

    public static String getRow(String column, String type, boolean primaryKey, boolean autoincrement) {
        String auto = autoincrement ? " AUTOINCREMENT" : "",
                key = primaryKey ? " PRIMARY KEY" : "";
        return String.format("%s %s%s%s", column, type, key, auto);
    }

    public static String getRow(String column, String type, boolean primaryKey) {
        return getRow(column, type, primaryKey, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getCreateTable(String tableName, String... row) {
        String rows = String.join(", ", row);
        return String.format(CREATE_TABLE, tableName, rows);
    }

    public static String getDropTable(String tableName) {
        return String.format(DROP_TABLE, tableName);
    }

    public static final class NotesEntry implements BaseColumns {
        public static final String TABLE_NAME = "notes";

        public static final String COLUMN_TITLE = "title",
                                   COLUMN_DESCRIPTION = "description",
                                   COLUMN_DAY_OF_WEEK = "day_of_week",
                                   COLUMN_PRIORITY = "priority";

        @RequiresApi(api = Build.VERSION_CODES.O)
        public static String createTable() {
            String id = getRow(_ID, TYPE_INTEGER, true, true),
                   title = getRow(COLUMN_TITLE, TYPE_TEXT),
                   description = getRow(COLUMN_DESCRIPTION, TYPE_TEXT),
                   day = getRow(COLUMN_DAY_OF_WEEK, TYPE_INTEGER),
                   priority = getRow(COLUMN_PRIORITY, TYPE_INTEGER);

            return getCreateTable(TABLE_NAME, id, title, description, day, priority);
        }

        public static String dropTable() {
            return getDropTable(TABLE_NAME);
        }
    }
}