package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16395 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[31][31];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;

        for(int i=3; i<=30; i++) {
            dp[i][1] = 1;
            dp[i][i] = 1;
        }

        for(int i=3; i<=30; i++) {
            for(int j=2; j<i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}
