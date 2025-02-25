package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for(int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine());
            int sticker = Integer.parseInt(st.nextToken());

            int[][] arr = new int[2][sticker];
            int[][] dp = new int[2][sticker];

            for(int j=0; j<2; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<sticker; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            int max = Math.max(dp[0][0], dp[1][0]);

            for(int q=1; q<sticker; q++) {
                if (q == 1) {
                    dp[0][q] = dp[1][0] + arr[0][1];
                    dp[1][q] = dp[0][0] + arr[1][1];
                    max = Math.max(dp[0][q], dp[1][q]);
                    continue;
                }
                dp[0][q] = Math.max(dp[1][q-1], dp[1][q-2]) + arr[0][q];
                dp[1][q] = Math.max(dp[0][q-1], dp[0][q-2]) + arr[1][q];
                max = Math.max(max, Math.max(dp[0][q], dp[1][q]));
            }
            sb.append(max + "\n");
        }
        System.out.println(sb);
    }
}
