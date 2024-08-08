package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        String n = s[0];
        StringBuffer sb = new StringBuffer(n);
        int reverse1 = Integer.parseInt(sb.reverse().toString());

        String m = s[1];
        sb = new StringBuffer(m);
        int reverse2 = Integer.parseInt(sb.reverse().toString());

        System.out.println(Math.max(reverse1, reverse2));
    }
}
