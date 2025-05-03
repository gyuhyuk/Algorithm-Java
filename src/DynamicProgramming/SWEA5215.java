package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] dp = new int[L+1];
            int[][] items = new int[N+1][2]; // 1번 인덱스부터 사용

            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());

                int value = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                items[i][0] = value; // 가치
                items[i][1] = weight; // 무게

                for(int w=L; w>=weight; w--) {
                    dp[w] = Math.max(dp[w], dp[w-weight] + value);
                }
            }

            System.out.println("#" + t + " " + dp[L]);
        }
    }
}
