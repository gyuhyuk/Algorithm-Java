package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ10826 {
    static BigInteger[] fib;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        fib = new BigInteger[10001];
        fib[0] = BigInteger.valueOf(0);
        fib[1] = BigInteger.valueOf(1);

        for(int i=2; i<=10000; i++) {
            fib[i] = fib[i-1].add(fib[i-2]);
        }

        System.out.println(fib[N]);
    }
}
