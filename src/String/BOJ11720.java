package String;

import java.util.Scanner;

public class BOJ11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int user = scanner.nextInt();

        String sNum = scanner.next();
        char[] cNum = sNum.toCharArray();

        int sum = 0;

        for(int i=0; i<cNum.length; i++) {
            sum += cNum[i] - '0';
        }

        System.out.println(sum);
    }
}
