package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int sum = 0;
            int temp = 0;
            String s = br.readLine();
            for(int j=0; j<s.length(); j++) {
                char c = s.charAt(j);
                if(c == 'O') {
                    temp++;
                    sum += temp;
                } else {
                    temp = 0;
                }
            }

            System.out.println(sum);
        }
    }
}
