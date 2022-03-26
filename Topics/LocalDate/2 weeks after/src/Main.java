import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        LocalDate now = LocalDate.parse(dateString);
        System.out.println(now.plusWeeks(2));
    }
}