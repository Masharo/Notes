package com.example.notes;

import android.content.Context;

public class Note {
    private String title,
                   description;
    private  DayOfWeek dayOfWeek;
    private Priority priority;

    public Note(String title, String description, DayOfWeek dayOfWeek, Priority priority) {
        this.title = title;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDayOfWeek() {
        return dayOfWeek.getName();
    }

    public int getPriority(Context context) {
        return priority.getColor(context);
    }
}
