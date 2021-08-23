package com.example.notes;

import static androidx.recyclerview.widget.ItemTouchHelper.START;
import static androidx.recyclerview.widget.ItemTouchHelper.END;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String POSITION = "POSITION";

    private RecyclerView recyclerViewNotes;
    private static ArrayList<Note> notes;
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNotes = findViewById(R.id.recyclerview_main_notes);
        notes = new ArrayList<>();
        adapter = new NotesAdapter(this, notes);

        addNotesDefaultValue();
        instanceNote();
    }

    public static ArrayList<Note> getNotes() {
        return notes;
    }

    private void instanceNote() {
        recyclerViewNotes.setAdapter(adapter);

        adapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(int position) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                intent.putExtra(Note.NAME, notes.get(position));
                intent.putExtra(MainActivity.POSITION, position);

                startActivity(intent);
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onLongClick(int position) {
                notes.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, START | END) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                remove(viewHolder.getLayoutPosition());
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerViewNotes);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void remove(int position) {
        notes.remove(position);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void addNotesDefaultValue() {
        notes.addAll(new ArrayList<Note>() {{
            add(new Note("Парикмахер", "Сделать прическу как у дэба", DayOfWeek.SATURDAY, Priority.RED));
            add(new Note("Работа", "Не проспать работу", DayOfWeek.FRIDAY, Priority.GREEN));
            add(new Note("Дота", "Выйграть катку в доту", DayOfWeek.TUESDAY, Priority.YELLOW));
        }});

        adapter.notifyDataSetChanged();
    }

    public void onClickAddNote(View view) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }
}