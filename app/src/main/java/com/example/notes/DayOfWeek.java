package com.example.notes;

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
}
