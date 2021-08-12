package com.example.notes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNotes = findViewById(R.id.recyclerview_main_notes);

        notes = new ArrayList<Note>() {{
            add(new Note("Парикмахер", "Сделать прическу как у дэба", DayOfWeek.SATURDAY, ColorCard.RED));
            add(new Note("Работа", "Не проспать работу", DayOfWeek.FRIDAY, ColorCard.GREEN));
            add(new Note("Дота", "Выйграть катку в доту", DayOfWeek.TUESDAY, ColorCard.YELLOW));
            add(new Note("Парикмахер", "Сделать прическу как у дэба", DayOfWeek.SATURDAY, ColorCard.RED));
            add(new Note("Работа", "Не проспать работу", DayOfWeek.FRIDAY, ColorCard.GREEN));
            add(new Note("Дота", "Выйграть катку в доту", DayOfWeek.TUESDAY, ColorCard.YELLOW));
            add(new Note("Парикмахер", "Сделать прическу как у дэба", DayOfWeek.SATURDAY, ColorCard.RED));
            add(new Note("Работа", "Не проспать работу", DayOfWeek.FRIDAY, ColorCard.GREEN));
            add(new Note("Дота", "Выйграть катку в доту", DayOfWeek.TUESDAY, ColorCard.YELLOW));
            add(new Note("Парикмахер", "Сделать прическу как у дэба", DayOfWeek.SATURDAY, ColorCard.RED));
            add(new Note("Работа", "Не проспать работу", DayOfWeek.FRIDAY, ColorCard.GREEN));
            add(new Note("Дота", "Выйграть катку в доту", DayOfWeek.TUESDAY, ColorCard.YELLOW));
            add(new Note("Парикмахер", "Сделать прическу как у дэба", DayOfWeek.SATURDAY, ColorCard.RED));
            add(new Note("Работа", "Не проспать работу", DayOfWeek.FRIDAY, ColorCard.GREEN));
            add(new Note("Дота", "Выйграть катку в доту", DayOfWeek.TUESDAY, ColorCard.YELLOW));
            add(new Note("Парикмахер", "Сделать прическу как у дэба", DayOfWeek.SATURDAY, ColorCard.RED));
            add(new Note("Работа", "Не проспать работу", DayOfWeek.FRIDAY, ColorCard.GREEN));
            add(new Note("Дота", "Выйграть катку в доту", DayOfWeek.TUESDAY, ColorCard.YELLOW));
            add(new Note("Парикмахер", "Сделать прическу как у дэба", DayOfWeek.SATURDAY, ColorCard.RED));
            add(new Note("Работа", "Не проспать работу", DayOfWeek.FRIDAY, ColorCard.GREEN));
            add(new Note("Дота", "Выйграть катку в доту", DayOfWeek.TUESDAY, ColorCard.YELLOW));
            add(new Note("Парикмахер", "Сделать прическу как у дэба", DayOfWeek.SATURDAY, ColorCard.RED));
            add(new Note("Работа", "Не проспать работу", DayOfWeek.FRIDAY, ColorCard.GREEN));
            add(new Note("Дота", "Выйграть катку в доту", DayOfWeek.TUESDAY, ColorCard.YELLOW));
        }};

        NotesAdapter adapter = new NotesAdapter(this, notes);
        recyclerViewNotes.setAdapter(adapter);
    }
}