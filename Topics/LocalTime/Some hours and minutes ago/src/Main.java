import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalTime time = LocalTime.parse(scanner.nextLine());
        String hoursMins = scanner.nextLine();
        int[] result = Arrays.stream(hoursMins.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(time.minusHours(result[0]).minusMinutes(result[1]));
    }
}
