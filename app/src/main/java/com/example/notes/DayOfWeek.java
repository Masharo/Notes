package com.example.notes;

import androidx.annotation.IdRes;

import java.util.Arrays;

public enum DayOfWeek {

    MONDAY {
        @Override
        public int getName() {
            return R.string.text_dayofweek_monday;
        }
    },
    TUESDAY {
        @Override
        public int getName() {
            return R.string.text_dayofweek_tuesday;
        }
    },
    WEDNESDAY {
        @Override
        public int getName() {
            return R.string.text_dayofweek_wednesday;
        }
    },
    THURSDAY {
        @Override
        public int getName() {
            return R.string.text_dayofweek_thursday;
        }
    },
    FRIDAY {
        @Override
        public int getName() {
            return R.string.text_dayofweek_friday;
        }
    },
    SATURDAY {
        @Override
        public int getName() {
            return R.string.text_dayofweek_saturday;
        }
    },
    SUNDAY {
        @Override
        public int getName() {
            return R.string.text_dayofweek_sunday;
        }
    };

    public abstract int getName();

    public static DayOfWeek searchDay(@IdRes int resourceId) {
        return Arrays.stream(DayOfWeek.values()) .filter(i -> i.getName() == resourceId)
                .findFirst()
                .orElse(null);
    }

    public static int getId(DayOfWeek day) {
        return Arrays.binarySearch(DayOfWeek.values(), day);
    }
}
