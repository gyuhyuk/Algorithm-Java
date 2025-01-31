package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2156 {
    static long[] arr;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        arr = new long[10001];
        dp = new long[10001];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], (dp[i-3] + arr[i-1] + arr[i])));
            // dp[i-1]이랑 비교를 해주는게 핵심이다...
        }

        System.out.println(dp[n]);
    }
}
