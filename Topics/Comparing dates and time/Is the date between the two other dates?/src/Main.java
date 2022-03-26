import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] dateStrings = scanner.nextLine().split(" ");
        LocalDate x = LocalDate.parse(dateStrings[0]);
        LocalDate m = LocalDate.parse(dateStrings[1]);
        LocalDate n = LocalDate.parse(dateStrings[2]);

        boolean answer = false;
        boolean mxn = m.isBefore(x) && n.isAfter(x);
        boolean nxm = n.isBefore(x) && m.isAfter(x);

        if (mxn || nxm && !m.isEqual(n)) {
            answer = true;
        }
        System.out.println(answer);

    }
}