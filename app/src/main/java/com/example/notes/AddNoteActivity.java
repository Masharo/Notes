package com.example.notes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Arrays;

public class AddNoteActivity extends Activity {

    private Spinner dayOfWeek;
    private RadioGroup groupPriority;

    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        dayOfWeek = findViewById(R.id.spinner_addnote_dayofweek);
        groupPriority = findViewById(R.id.radiogroup_addnote_grouppriority);

        instanceDayOfWeek();
    }

    private void instanceDayOfWeek() {

        String[] array = Arrays .stream(DayOfWeek.values())
                                .map(i -> getString(i.getName()))
                                .toArray(String[]::new);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dayOfWeek.setAdapter(adapter);
    }

    private void saveDataInNote() {
        Priority priority = Priority.searchPriority(groupPriority.getCheckedRadioButtonId());
        // TODO DayOfWeek day = DayOfWeek.searchDay();
    }

    public void onClickSave(View view) {


    }
}