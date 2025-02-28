package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        long[] fib = new long[1000001];

        fib[0] = 0;
        fib[1] = 1;

        for(int i=2; i<=1000000; i++) {
            fib[i] = (fib[i-1] + fib[i-2]) % 1000000007;
        }

        System.out.println(fib[N]);
    }
}
