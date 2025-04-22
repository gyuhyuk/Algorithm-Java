package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int length = s.length();

        for(int i=0; i<length; i+=10) {
            if(i + 10 > length) {
                System.out.println(s.substring(i));
            } else {
                System.out.println(s.substring(i, i+10));
            }
        }
    }
}
