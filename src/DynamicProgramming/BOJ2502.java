package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] dp = new int[31][2];
        dp[1] = new int[]{1, 0};
        dp[2] = new int[]{0, 1};

        for(int i=3; i<=30; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i-1][0] + dp[i-1][1];
        }

        int x = dp[A][0];
        int y = dp[A][1];

        for(int i=1; i<=B/x; i++) {
            if((B - (x*i)) % y == 0) {
                int a = (B - (x*i)) / y;
                System.out.println(i);
                System.out.println(a);
                break;
            }
        }
    }
}
