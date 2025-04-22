package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if(s.length() == 1) {
            System.out.println("1");
            System.exit(0);
        }

        if(s.length() == 2) {
            if(s.charAt(0) == s.charAt(1)) {
                System.out.println("1");
                System.exit(0);
            } else {
                System.out.println("0");
                System.exit(0);
            }
        }
        int leftIndex = 0;
        int rightIndex = 0;

        if(s.length() % 2 == 0) {
            rightIndex = s.length() / 2;
            leftIndex = s.length() / 2 - 1;
        } else {
            rightIndex = s.length() / 2 + 1;
            leftIndex = s.length() / 2 - 1;
        }


        while (leftIndex >= 0 && rightIndex < s.length()) {
            if(s.charAt(leftIndex) == s.charAt(rightIndex)) {
                leftIndex--;
                rightIndex++;
            } else {
                System.out.println("0");
                return;
            }
        }

        System.out.println("1");
    }
}
