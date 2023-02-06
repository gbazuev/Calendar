package CalendarProject;

import java.util.Scanner;

public class Date {
    int year;

    Date() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год: ");
        this.year = validateYear(scanner.nextInt());
    }

    boolean checkLeapYear(int year) {
        return (year % 400 == 0)
                || (year % 4 == 0) && (year % 100 != 0);
    }

    int validateYear(int year) {
        Scanner scanner = new Scanner(System.in);
        while (year < 1583) {
            System.out.println("Введите год, который не меньше 1583: ");
            year = scanner.nextInt();
        }
        return year;
    }

     int getStartDay() {
        int loopYear = 2023, loopVal = 6;

        while (loopYear < this.year) {
            if (checkLeapYear(loopYear)) {
                loopVal += 2;
                loopYear++;
                loopVal = checkDay(loopVal, true);
                continue;
            }
            loopYear++;
            loopVal++;
            loopVal = checkDay(loopVal, true);
        }

        while (loopYear > this.year) {
            if (checkLeapYear(loopYear)) {
                loopVal -= 2;
                loopYear--;
                loopVal = checkDay(loopVal, false);
                continue;
            }
            loopYear--;
            loopVal--;
            loopVal = checkDay(loopVal, false);
        }

        return loopVal;
    }

    static int checkDay(int day, boolean status) {
        if (status) {
            if (day > 6) {
                return day - 7;
            }
            return day;
        } else {
            if (day < 0) {
                return day + 7;
            }
            return day;
        }
    }
}
