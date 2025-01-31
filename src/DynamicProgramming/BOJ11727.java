package DynamicProgramming;

import java.util.Scanner;

public class BOJ11727 {
    static int[] dp;
    public static void main(String[] args) {
        dp = new int[1001];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp[1] = 1;
        dp[2] = 3;
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
