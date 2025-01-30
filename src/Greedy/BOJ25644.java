package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25644 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int now = Integer.parseInt(st.nextToken());

            result = Math.max(result, now - min);
            min = Math.min(min, now);
        }

        System.out.println(result);
    }
}
