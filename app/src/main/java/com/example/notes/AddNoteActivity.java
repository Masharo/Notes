package com.example.notes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.Objects;

public class AddNoteActivity extends Activity {

    private Spinner dayOfWeek;
    private RadioGroup groupPriority;
    private EditText title,
                     description;

    private boolean isNew;

    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        isNew = true;

        dayOfWeek = findViewById(R.id.spinner_addnote_dayofweek);
        groupPriority = findViewById(R.id.radiogroup_addnote_grouppriority);
        title = findViewById(R.id.edittext_addnote_title);
        description = findViewById(R.id.edittext_addnote_description);

        instanceDayOfWeek();
        isNotNewNote();
    }

    private void isNotNewNote() {
        if (Objects.nonNull(getIntent()) &&
            getIntent().hasExtra(Note.NAME) &&
            getIntent().hasExtra(MainActivity.POSITION)) {

            isNew = false;

            Note noteLocal = (Note) getIntent().getSerializableExtra(Note.NAME);
            instanceNote(noteLocal.getTitle(),
                         noteLocal.getDescription(),
                         noteLocal.getPriority(),
                         noteLocal.getDayOfWeek());
        }
    }

    private void instanceNote(String title, String description, Priority priority, DayOfWeek day) {
        this.title.setText(title);
        this.description.setText(description);
        this.groupPriority.check(priority.getId());
        this.dayOfWeek.setSelection(DayOfWeek.getId(day));
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
        DayOfWeek day = DayOfWeek.values()[dayOfWeek.getSelectedItemPosition()];
        String title = this.title.getText().toString().trim();
        String description = this.description.getText().toString().trim();

        note = new Note(title, description, day, priority);
    }

    public void onClickSave(View view) {

        saveDataInNote();

        if (isNew) {
            MainActivity.getNotes().add(note);
        } else {
            int position = getIntent().getIntExtra(MainActivity.POSITION, -1);

            MainActivity.getNotes().set(position, note);
        }

        finish();
    }
}