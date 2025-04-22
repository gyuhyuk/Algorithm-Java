package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];

        String s = br.readLine();

        for(char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }

        for(int i=0; i<26; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}
