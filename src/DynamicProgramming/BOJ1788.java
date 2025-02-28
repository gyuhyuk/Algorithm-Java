package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1788 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        long[] plusFib = new long[1000001];
        long[] minusFib = new long[1000001];

        plusFib[0] = 0;
        plusFib[1] = 1;
        for(int i=2; i<=1000000; i++) {
            plusFib[i] = (plusFib[i-1] + plusFib[i-2]) % 1000000000;
        }

        minusFib[0] = 0;
        minusFib[1] = 1;
        for(int i=2; i<=1000000; i++) {
            minusFib[i] = (minusFib[i-1] + minusFib[i-2]) % 1000000000;
        }

        if(N > 0) {
            System.out.println(1);
            System.out.println(plusFib[N]);
        } else if (N < 0) {
            if(Math.abs(N) % 2 == 0) {
                System.out.println(-1);
                System.out.println(minusFib[Math.abs(N)]);
            } else {
                System.out.println(1);
                System.out.println(minusFib[Math.abs(N)]);
            }
        }
        else {
            System.out.println(0);
            System.out.println(0);
        }
    }
}
