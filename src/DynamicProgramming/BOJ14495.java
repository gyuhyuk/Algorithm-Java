package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] fib = new long[117];

        fib[1] = 1;
        fib[2] = 1;
        fib[3] = 1;

        for(int i=4; i<=116; i++) {
            fib[i] = fib[i-1] + fib[i-3];
        }

        System.out.println(fib[N]);
    }
}
