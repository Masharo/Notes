package com.example.notes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.stream.Stream;

public class AddNoteActivity extends Activity {

    private Spinner dayOfWeek;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        dayOfWeek = findViewById(R.id.spinner_addnote_dayofweek);

        instanceDayOfWeek();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void instanceDayOfWeek() {

        String[] array = Arrays.stream(DayOfWeek.values()).map(i -> getString(i.getName())).toArray();

        for (String i : array) {
            Log.i("MyLog", i);
        }
//        @SuppressLint("ResourceType")
//        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ;
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        for (DayOfWeek day : DayOfWeek.values()) {
//            adapter.add(getString(day.getName()));
//        }
//
//        dayOfWeek.setAdapter(adapter);
    }
}