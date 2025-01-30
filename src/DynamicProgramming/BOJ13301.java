package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ13301 {
    static BigInteger[] fib;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        fib = new BigInteger[81];

        fib[1] = BigInteger.valueOf(4);
        fib[2] = BigInteger.valueOf(6);

        int N = Integer.parseInt(st.nextToken());

        for(int i=3; i<=80; i++) {
            fib[i] = fib[i-1].add(fib[i-2]);
        }

        System.out.println(fib[N]);

    }
}
