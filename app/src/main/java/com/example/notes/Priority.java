package com.example.notes;

import android.content.Context;

import androidx.annotation.IdRes;

import java.util.Arrays;
import java.util.Optional;

public enum Priority {
    RED {
        @Override
        public String getName(Context view) {
            return view.getResources().getString(R.string.color_colorcard_red);
        }

        @Override
        public int getColor(Context view) {
            return view.getResources().getColor(R.color.red);
        }

        @Override
        public int getId() {
            return R.id.radiobutton_addnote_priorityhigh;
        }
    },
    YELLOW {
        @Override
        public String getName(Context view) {
            return view.getResources().getString(R.string.color_colorcard_yellow);
        }

        @Override
        public int getColor(Context view) {
            return view.getResources().getColor(R.color.green);
        }

        @Override
        public int getId() {
            return R.id.radiobutton_addnote_prioritymedium;
        }
    },
    GREEN {
        @Override
        public String getName(Context view) {
            return view.getResources().getString(R.string.color_colorcard_green);
        }

        @Override
        public int getColor(Context view) {
            return view.getResources().getColor(R.color.yellow);
        }

        @Override
        public int getId() {
            return R.id.radiobutton_addnote_prioritylow;
        }
    };

    public abstract String getName(Context view);
    public abstract int getColor(Context view);
    public abstract int getId();

    public Priority searchPriority(@IdRes int resourcesId) {
        return Arrays.stream(Priority.values()) .filter(i -> i.getId() == resourcesId)
                                                .findFirst()
                                                .orElse(null);
    }
}
