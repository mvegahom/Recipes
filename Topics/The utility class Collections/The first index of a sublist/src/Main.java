import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> seq1String = List.of(scanner.nextLine().split(" "));
        List<String> seq2String = List.of(scanner.nextLine().split(" "));

        List<Integer> seq1 = new ArrayList<>();
        for (String ele:seq1String) {
            seq1.add(Integer.parseInt(ele));
        }

        List<Integer> seq2 = new ArrayList<>();
        for (String ele:seq2String) {
            seq2.add(Integer.parseInt(ele));
        }

        int answer1 = Collections.indexOfSubList(seq1, seq2);
        int answer2 = Collections.lastIndexOfSubList(seq1, seq2);

        System.out.println(answer1 + " " + answer2);
    }
}