package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        dp = new int[30][30]; // dp[k][n] 으로 변경

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(bridge(n, m)).append("\n");
        }

        System.out.println(sb);
    }

    static int bridge(int n, int k) {
        if(dp[k][n] > 0) {
            return dp[k][n];
        }
        if(n == 0 || n == k) {
            return dp[k][n] = 1;
        }

        return dp[k][n] = bridge(n-1, k-1) + bridge(n, k-1);
    }
}
