import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> list = List.of(scanner.nextLine().split(" "));
        String ele = scanner.nextLine();
        int freq = Collections.frequency(list, ele);

        System.out.println(freq);
    }
}