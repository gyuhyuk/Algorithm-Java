package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2579 {
    static long[] dp;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new long[301];
        arr = new long[301];

        int n = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(arr[1], arr[2]) + arr[3];

        for(int i=4; i<=300; i++) {
            dp[i] = Math.max(dp[i-2], (dp[i-3] + arr[i-1])) + arr[i];
        }

        System.out.println(dp[n]);
    }
}
