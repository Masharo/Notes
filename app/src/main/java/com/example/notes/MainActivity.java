package com.example.notes;

import static androidx.recyclerview.widget.ItemTouchHelper.LEFT;
import static androidx.recyclerview.widget.ItemTouchHelper.RIGHT;

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
                //Note selectedNote = adapter.getNotes().get(i);

            }

            @Override
            public void onLongClick(int position) {
                notes.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, LEFT | RIGHT) {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                return 0;
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                remove(viewHolder.getAdapterPosition());
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerViewNotes);
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