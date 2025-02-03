package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSAT6284 {
    static long[] dp;
    static final long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long k = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        dp = new long[n+1];
        dp[0] = k;

        for(int i=1; i<=n; i++) {
            dp[i] = (dp[i-1] * p) % MOD;
        }

        System.out.println(dp[n]);
    }
}
