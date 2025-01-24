package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ26068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int k = Integer.parseInt(s.substring(2, s.length()));
            if(k <= 90) {
                count++;
            }
        }
        System.out.println(count);
    }
}
