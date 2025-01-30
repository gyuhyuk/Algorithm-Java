package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19947 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        dp = new int[11];

        dp[0] = H;
        dp[1] = (int) (dp[0] * 1.05);
        dp[2] = (int) (dp[1] * 1.05);

        for(int i=3; i<=10; i++) {
            if(i >= 5) {
                dp[i] = (int) Math.max(Math.max(dp[i-1]*1.05, dp[i-3]*1.2), dp[i-5]*1.35);
            }
            else {
                dp[i] = (int) Math.max(dp[i-1]*1.05, dp[i-3]*1.2);
            }
        }

        System.out.println(dp[Y]);
    }
}
