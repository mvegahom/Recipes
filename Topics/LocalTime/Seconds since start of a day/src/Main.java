import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        long nSeconds = Integer.parseInt(scanner.nextLine());

        System.out.println(LocalTime.ofSecondOfDay(nSeconds));
    }
}
