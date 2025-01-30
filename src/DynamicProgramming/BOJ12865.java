package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {
    static int N, K;
    static int[][] dp;
    static int[] weight;
    static int[] value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][K+1];
        weight = new int[N+1];
        value = new int[N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                dp[i][j] = dp[i-1][j]; // 기본적으로 이전 아이템 가치 저장
                if(j - weight[i] >= 0) { // 무게에서 자신의 무게를 뺐을 때 남는 무게가 존재하면
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]); // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의 가치 중 큰 값을 취한다.
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
