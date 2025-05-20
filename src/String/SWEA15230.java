package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA15230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String answer = "abcdefghijklmnopqrstuvwxyz";

        for(int t=1; t<=T; t++) {
           int count = 0;
           String s = br.readLine();

            for(int i=0; i<s.length(); i++) {
                char temp = s.charAt(i);
                if(temp == answer.charAt(i)) {
                    count++;
                } else {
                    break;
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}
