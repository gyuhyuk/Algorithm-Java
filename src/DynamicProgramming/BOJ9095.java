package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9095 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(st.nextToken());

        for(int i=0; i<testcase; i++) {
            dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for(int j=4; j<=n; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
                sb.append(dp[n]).append("\n");

        }

        System.out.println(sb);
    }
}
