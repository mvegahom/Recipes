import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int ndates = Integer.parseInt(scanner.nextLine());
        LocalDateTime latestOne = LocalDateTime.parse(scanner.nextLine());

        for (int i = 1; i < ndates; i++) {
            LocalDateTime current = LocalDateTime.parse(scanner.nextLine());
            if (current.isAfter(latestOne)) {
                latestOne = current;
            }
        }

        System.out.println(latestOne);
    }
}