package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1564 {
    static long mod = (long) 1e12;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] fib = new long[N+1];
        long num;

        fib[1] = 1;

        for(int i=2; i<=N; i++) {
            fib[i] = fib[i-1] * i;
            while (fib[i] % 10 == 0) {
                fib[i] /= 10;
            }

            fib[i] %= mod;
        }

        num = fib[N] % 100000;

        System.out.printf("%05d", num);
    }
}
