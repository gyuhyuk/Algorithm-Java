package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean inTag = false;

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if(c == '<') {
                inTag = true;
                sb.append(word.reverse());
                word.setLength(0);
                sb.append(c);
            } else if(c == '>') {
                inTag = false;
                sb.append(c);
            } else if (inTag) {
                sb.append(c);
            } else {
                if(c == ' ') {
                    sb.append(word.reverse());
                    sb.append(' ');
                    word.setLength(0);
                } else {
                    word.append(c);
                }
            }
        }
        sb.append(word.reverse());

        System.out.println(sb);
    }
}
