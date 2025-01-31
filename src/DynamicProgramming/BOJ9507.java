package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9507 {
    static long[] fib;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        fib = new long[68];
        fib[0] = 1;
        fib[1] = 1;
        fib[2] = 2;
        fib[3] = 4;

        int n = Integer.parseInt(st.nextToken());

        for(int i=4; i<=67; i++) {
            fib[i] = fib[i-1] + fib[i-2] + fib[i-3] + fib[i-4];
        }

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int user = Integer.parseInt(st.nextToken());
            sb.append(fib[user]).append("\n");
        }

        System.out.println(sb);
    }
}
