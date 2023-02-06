package CalendarProject;

public class WhiteSpace {

     String  buildStartWhiteSpace(int startDay)   {
        StringBuilder whiteSpaceBuilder = new StringBuilder();
        for (int i = 0; i < startDay; ++i)  {
             whiteSpaceBuilder.append("     ");
        }
        return whiteSpaceBuilder.toString();
    }

     String buildWhiteSpace(int number) {
        StringBuilder whiteSpaceBuilder = new StringBuilder();
        if (number > 9) {
            whiteSpaceBuilder.append("   ");
        }
        else {
            whiteSpaceBuilder.append("    ");
        }
        return whiteSpaceBuilder.toString();
    }

      String clear() {
       return "";
    }
}
