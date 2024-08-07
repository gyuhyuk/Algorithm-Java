package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        for(int i=0; i<testcase; i++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            String m = s[1];

            for(int j=0; j<m.length(); j++) {
                for(int k=0; k<n; k++) {
                    System.out.print(m.charAt(j));
                }
            }
            System.out.println();
        }
    }
}