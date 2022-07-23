package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int monthOfBirth = scanner.nextInt();
        int dayOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();

        DaysAliveCalculator daysAliveCalculator = new DaysAliveCalculator(monthOfBirth, dayOfBirth, yearOfBirth);
        System.out.println(daysAliveCalculator.numDaysAlive());
    }
}
