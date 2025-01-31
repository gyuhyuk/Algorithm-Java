package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {
    static long[] dp;
    static long[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        card = new long[n+1];
        dp = new long[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            int a = Integer.parseInt(st.nextToken());
            card[i] = a;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + card[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
