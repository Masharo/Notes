package com.example.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private static ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNotes = findViewById(R.id.recyclerview_main_notes);
        notes = new ArrayList<>();

        addNotesDefaultValue();
        instanceNote();
    }

    public void onClickListNotes(View view) {
        //recyclerViewNotes.getItem;
    }

    public static ArrayList<Note> getNotes() {
        return notes;
    }

    private void instanceNote() {
        NotesAdapter adapter = new NotesAdapter(this, notes);
        recyclerViewNotes.setAdapter(adapter);

        adapter.setOnNoteClickListener(i -> {
            Note selectedNote = adapter.getNotes().get(i);
            Toast.makeText(getApplicationContext(), selectedNote.getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    private void addNotesDefaultValue() {
        notes.addAll(new ArrayList<Note>() {{
            add(new Note("Парикмахер", "Сделать прическу как у дэба", DayOfWeek.SATURDAY, Priority.RED));
            add(new Note("Работа", "Не проспать работу", DayOfWeek.FRIDAY, Priority.GREEN));
            add(new Note("Дота", "Выйграть катку в доту", DayOfWeek.TUESDAY, Priority.YELLOW));
        }});
    }

    public void onClickAddNote(View view) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }
}