package DynamicProgramming;

import java.util.*;
import java.io.*;

public class HSAT6280 {
    static long[] arr;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new long[16];
        dp = new long[16];

        for(int i=1; i<=15; i++) {
            arr[i] = (long) Math.pow(2, (i-1)); // 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768
        }

        dp[1] = 9;

        for(int i=2; i<=15; i++) {
            dp[i] = (long) Math.pow((Math.sqrt(dp[i-1]) + arr[i]), 2); // dp[2] = dp[1] + arr[3];
        }


        System.out.println(dp[N]);
    }
}
