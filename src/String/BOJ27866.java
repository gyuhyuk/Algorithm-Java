package String;

import java.util.Scanner;

public class BOJ27866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        System.out.println(s.charAt(scanner.nextInt()-1));

    }
}
