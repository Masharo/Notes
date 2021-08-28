package com.example.notes;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "notes")
public class Note implements Serializable {

    public transient static final String NAME = "NOTE";

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String title,
                   description;
    private  DayOfWeek dayOfWeek;
    private Priority priority;

    @Ignore
    public Note(@NonNull String title, @NonNull String description,
                @NonNull DayOfWeek dayOfWeek, @NonNull Priority priority) {

        this.title = title;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public Note(@NonNull Integer id, @NonNull String title, @NonNull String description,
                @NonNull DayOfWeek dayOfWeek, @NonNull Priority priority) {

        this(title, description, dayOfWeek, priority);
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setId(Integer id) {
        assert Objects.nonNull(id); //Только для обьектов у которых изначально не был указан id
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDayOfWeekResId() {
        return dayOfWeek.getName();
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getPriority(Context context) {
        return priority.getColor(context);
    }
}
