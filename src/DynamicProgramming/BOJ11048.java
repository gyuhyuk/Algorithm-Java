package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = A[1][1];

        for(int i=2; i<=M; i++) {
            dp[1][i] = dp[1][i-1] + A[1][i];
        }
        for(int i=2; i<=N; i++){
            dp[i][1] = A[i][1] + dp[i-1][1];
        }

        for(int i=2; i<=N; i++) {
            for(int j=2; j<=M; j++) {
                dp[i][j] = A[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }

        System.out.println(dp[N][M]);
    }
}
