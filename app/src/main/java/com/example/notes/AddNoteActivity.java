package com.example.notes;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;

public class AddNoteActivity extends Activity {

    private Spinner dayOfWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        dayOfWeek = findViewById(R.id.spinner_addnote_dayofweek);

        instanceDayOfWeek();
    }

    private void instanceDayOfWeek() {

        String[] array = Arrays .stream(DayOfWeek.values())
                                .map(i -> getString(i.getName()))
                                .toArray(String[]::new);

        for (String i : array) {
            Log.i("MyLog", i);
        }

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dayOfWeek.setAdapter(adapter);
    }
}