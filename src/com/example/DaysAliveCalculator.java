package com.example;

import java.time.LocalDate;
import java.time.Year;

public class DaysAliveCalculator {

    private final int monthOfBirth;
    private final int dayOfBirth;
    private final int yearOfBirth;
    private final int[] numDaysInMonthNoLeap = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int[] numDaysInMonthLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public DaysAliveCalculator(int monthOfBirth, int dayOfBirth, int yearOfBirth) {
        this.monthOfBirth = monthOfBirth;
        this.dayOfBirth = dayOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String numDaysAlive() {
        LocalDate currentDate = LocalDate.now();

        int yearWeAreIn = currentDate.getYear();
        int monthWeAreIn = currentDate.getMonthValue();
        int dayWeAreIn = currentDate.getDayOfMonth();

        int currentYear = this.yearOfBirth;

        int dayCounter = 0;

        // calculate number of days alive in full years lived
        while (currentYear < yearWeAreIn) {

            // handle the first year alive
            if (currentYear == this.yearOfBirth) {
                if (isLeapYear(currentYear)) {
                    dayCounter += numDaysInMonthLeap[this.monthOfBirth - 1] - this.dayOfBirth;
                    for (int i = this.monthOfBirth; i < numDaysInMonthLeap.length; i++) {
                        dayCounter += numDaysInMonthLeap[i];
                    }
                } else {
                    dayCounter += numDaysInMonthNoLeap[this.monthOfBirth - 1] - this.dayOfBirth;
                    for (int i = this.monthOfBirth; i < numDaysInMonthNoLeap.length; i++) {
                        dayCounter += numDaysInMonthNoLeap[i];
                    }
                }
            } else { // handle all other years up until current year
                if (isLeapYear(currentYear)) {
                    dayCounter += 366;
                } else {
                    dayCounter += 365;
                }
            }
            currentYear++;
        }

        // calculate remainder full months
        for (int i = 0; i < monthWeAreIn - 1; i++) {
            if (isLeapYear(currentYear)) {
                dayCounter += numDaysInMonthLeap[i];
            } else {
                dayCounter += numDaysInMonthNoLeap[i];
            }
        }

        // add the rest of the days
        dayCounter += dayWeAreIn;

        return "You have been alive " + dayCounter + " days.";
    }

    private boolean isLeapYear(int currentYear) {
        return Year.of(currentYear).isLeap();
    }
}
