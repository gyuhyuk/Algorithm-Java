package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if(input.equals("end")) {
                break;
            }

            if(containsVowel(input) && isValid(input)) {
                sb.append("<").append(input).append("> is acceptable.\n");
            }
            else {
                sb.append("<").append(input).append("> is not acceptable.\n");
            }
        }
        System.out.println(sb);
    }

    static boolean containsVowel(String str) {
        for (char c : str.toCharArray()) {
            if("aeiou".indexOf(c) != -1) {
                return true; // 모음이 하나라도 있으면 종료
            }
        }
        return false;
    }

    static boolean isValid(String str) {
        int vowelCount = 0;
        int consonantCount = 0;
        char prevChar = ' ';

        for(char c : str.toCharArray()) {
            if("aeiou".indexOf(c) != -1) {
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }
            if(vowelCount == 3 || consonantCount == 3) {
                return false;
            }

            if(c == prevChar && !(c == 'e' || c == 'o')) {
                return false;
            }

            prevChar = c;
        }

        return true;
    }
}
