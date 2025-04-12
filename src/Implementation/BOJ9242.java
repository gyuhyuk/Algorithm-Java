package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9242 {
    static String[] digits = {
            "***" + "* *" + "* *" + "* *" + "***", // 0
            "  *" + "  *" + "  *" + "  *" + "  *", // 1
            "***" + "  *" + "***" + "*  " + "***", // 2
            "***" + "  *" + "***" + "  *" + "***", // 3
            "* *" + "* *" + "***" + "  *" + "  *", // 4
            "***" + "*  " + "***" + "  *" + "***", // 5
            "***" + "*  " + "***" + "* *" + "***", // 6
            "***" + "  *" + "  *" + "  *" + "  *", // 7
            "***" + "* *" + "***" + "* *" + "***", // 8
            "***" + "* *" + "***" + "  *" + "***"  // 9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = new String[5];
        for (int i = 0; i < 5; i++) {
            input[i] = br.readLine();
        }

        int length = input[0].length();
        int numCount = (length + 1) / 4;

        List<String> numberPatterns = new ArrayList<>();
        for (int i = 0; i < numCount; i++) {
            StringBuilder sb = new StringBuilder();
            int start = i * 4;
            for (int j = 0; j < 5; j++) {
                sb.append(input[j], start, start + 3);
            }
            numberPatterns.add(sb.toString());
        }

        StringBuilder result = new StringBuilder();
        for (String pattern : numberPatterns) {
            boolean matched = false;
            for (int i = 0; i < 10; i++) {
                if (pattern.equals(digits[i])) {
                    result.append(i);
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                System.out.println("BOOM!!");
                return;
            }
        }

        int number = Integer.parseInt(result.toString());
        System.out.println(number % 6 == 0 ? "BEER!!" : "BOOM!!");
    }
}
