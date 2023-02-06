package CalendarProject;

public class Calendar {
    public static void main(String[] args) {
        //Инициализируем объект Date

        Date date = new Date();
        //Ищем день недели, с которого начинается год
        int startDay = date.getStartDay();

        //Выводим календарь
        printMonths(startDay, date);
    }

    static void printMonths(int startDay, Date date) {
        String[] months = {"ЯНВАРЬ", "ФЕВРАЛЬ", "МАРТ", "АПРЕЛЬ", "МАЙ", "ИЮНЬ", "ИЮЛЬ",
                "АВГУСТ", "СЕНТЯБРЬ", "ОКТЯБРЬ", "НОЯБРЬ", "ДЕКАБРЬ"};

        int[] monthsDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        monthsDays[1] = getFebruaryDays(date);

        WhiteSpace space = new WhiteSpace();
        String whiteSpace = "";

        for (int month = 0; month < months.length; month++) {
            System.out.println(months[month]);
            printWeekDays();

            StringBuilder local = new StringBuilder(whiteSpace);
            System.out.print("\n" + whiteSpace);
            for (int days = 1; days < monthsDays[month] + 1; days++) {

                 if (days == 1 && month == 0) {
                    whiteSpace = space.buildStartWhiteSpace(startDay);
                    local.append(whiteSpace);
                }
                else if (days == 1 && whiteSpace.equals(""))   {
                    local.append(days).append(whiteSpace);
                }
                else  {
                    whiteSpace = space.buildWhiteSpace(days);
                    local.append(days).append(whiteSpace);
                }

                if (local.length() >= 32) {
                    System.out.print("\n" + days + whiteSpace);
                    local.delete(0, local.length());
                    whiteSpace = space.clear();
                    continue;
                }

                 if (days == 1)  {
                    System.out.print(whiteSpace + days + space.buildWhiteSpace(days + 1));
                }
                else {
                    System.out.print(days + whiteSpace);
                }
                whiteSpace = space.clear();
            }
            System.out.println("\n\n");
            whiteSpace = transformLoopVal(local.toString());
        }
    }

    private static int getFebruaryDays(Date date) {
        return date.checkLeapYear(date.year) ? 29 : 28;
    }

    static void printWeekDays() {
        String[] weekDays = {"пн", "вт", "ср", "чт", "пт", "сб", "вс"};
        for (int i = 0; i < weekDays.length; i++) {
            System.out.print(weekDays[i] + "   ");
        }
    }

     static String transformLoopVal(String loopVal) {
        if (loopVal.length() + 5 >= 32) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < loopVal.length() + 1; ++i)  {
            res.append(" ");
        }
        return res.toString();
    }

    boolean checkWeekLength(String week)    {
        return week.length() >= 32;
    }
}
