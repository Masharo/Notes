package com.example.notes;

import android.content.Context;

public enum ColorCard {
    RED {
        @Override
        public String getName(Context view) {
            return view.getResources().getString(R.string.color_colorcard_red);
        }

        @Override
        public int getColor(Context view) {
            return view.getResources().getColor(R.color.red);
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
    };

    public abstract String getName(Context view);
    public abstract int getColor(Context view);
}
