import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        List<String> stringList = Arrays.asList(strings);
        int swapsNo = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < swapsNo; i++) {
            String[] twoStrings = scanner.nextLine().split(" ");
            int j = Integer.parseInt(twoStrings[0]);
            int k = Integer.parseInt(twoStrings[1]);
            Collections.swap(stringList, j, k);
        }

        String output = "";
        for (String ele: stringList) {
            output = output + ele + " ";
        }

        System.out.println(output);
    }
}