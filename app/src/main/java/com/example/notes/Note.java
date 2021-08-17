package com.example.notes;

import android.content.Context;

import androidx.annotation.NonNull;


public class Note {
    private String title,
                   description;
    private  DayOfWeek dayOfWeek;
    private Priority priority;

    public Note(@NonNull String title, @NonNull String description,
                @NonNull DayOfWeek dayOfWeek, @NonNull Priority priority) {

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

    public Priority getPriority() {
        return priority;
    }

    public int getPriority(Context context) {
        return priority.getColor(context);
    }
}
