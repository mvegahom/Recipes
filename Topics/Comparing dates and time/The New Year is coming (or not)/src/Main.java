import java.time.LocalDate;
import java.util.Scanner;

class Main {
    static final int DAYSINYEAR = 365;
    static final int FOUR = 4;
    static final int FOURHUNDRED = 400;
    static final String TWOZEROES = "00";

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] twoStrings = scanner.nextLine().split(" ");

        LocalDate date = LocalDate.parse(twoStrings[0]);
        int lastingDays = Integer.parseInt(twoStrings[1]);
        int year = date.getYear();

        int daysInYear = DAYSINYEAR;
        boolean leapYear;

        if (twoStrings[0].substring(2, 3).equals(TWOZEROES)) {
            leapYear = year % FOURHUNDRED == 0;
        } else {
            leapYear = year % FOUR == 0;
        }

        if (leapYear) {
            daysInYear = DAYSINYEAR + 1;
        }

        boolean answer;
        if (lastingDays == daysInYear - date.getDayOfYear() + 1) {
            answer = true;
        } else {
            answer = false;
        }

        System.out.println(answer);
    }
}