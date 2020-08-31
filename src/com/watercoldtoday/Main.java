package com.watercoldtoday;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.text.DateFormatSymbols;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        GregorianCalendar d = new GregorianCalendar();

        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        d.set(Calendar.DAY_OF_MONTH,1);

        int weekday = d.get(Calendar.DAY_OF_WEEK);

        int firstDayOfWeek = d.getFirstDayOfWeek();

        int indent = 0;
        while (weekday != firstDayOfWeek) {
            indent++;
            d.add(Calendar.DAY_OF_MONTH,-1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        //prints weekday names
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s",weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH,1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println();

        for (int i = 1; i <= indent; i++) {
            System.out.print("    ");
        }
        d.set(Calendar.DAY_OF_MONTH,1);
        do {
            //print day
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d",day);

            //mark current day with *
            if (day == today) System.out.print("*");
            else System.out.print(" ");

            //advanced d to the next day
            d.add(Calendar.DAY_OF_MONTH,1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
            if (weekday == firstDayOfWeek ) System.out.println();
        } while (d.get(Calendar.MONTH) == month);
        if (weekday != firstDayOfWeek) System.out.println();
    }
}
