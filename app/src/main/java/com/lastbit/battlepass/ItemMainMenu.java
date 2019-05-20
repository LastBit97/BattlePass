package com.lastbit.battlepass;

public class ItemMainMenu {
    private String week_will_opened; // дата выхода
    boolean locked;
    private int weekNumber;
    private String week_numbers;

    public String getWeek_numbers() {
        return week_numbers;
    }

    public void setWeek_numbers(String week_numbers) {
        this.week_numbers = week_numbers;
    }

    public ItemMainMenu(String week_name, boolean locked, String week_numbers, int weekNumber) {
        this.week_will_opened = week_name;
        this.locked = locked;
        this.week_numbers = week_numbers;
        this.weekNumber = weekNumber;
    }

    public String getWeek_will_opened() {
        return week_will_opened;
    }

    public void setWeek_will_opened(String week_will_opened) {
        this.week_will_opened = week_will_opened;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getWeekNumber() {
        return weekNumber;
    }
}
