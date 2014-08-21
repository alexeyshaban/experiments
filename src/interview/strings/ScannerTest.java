package interview.strings;

import java.io.InputStreamReader;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        try (Scanner s = new Scanner(new InputStreamReader(System.in))) {
            int sum = 0;
            while (s.hasNextInt()) {
                sum += s.nextInt();
            }
            System.out.println(sum);
        }
    }

}
