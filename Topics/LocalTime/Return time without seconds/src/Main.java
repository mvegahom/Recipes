import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String timeString = scanner.nextLine();
        LocalTime time = LocalTime.parse(timeString);
        LocalTime time2 = time.withSecond(0);
        System.out.println(time2);
    }
}