package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] items = new int[N+1][2]; // 체력, 기쁨
        int[] dp = new int[101]; // 최대 체력

       st = new StringTokenizer(br.readLine());
       for(int i=1; i<=N; i++) {
            items[i][0] = Integer.parseInt(st.nextToken());
       }

       st = new StringTokenizer(br.readLine());
       for(int i=1; i<=N; i++) {
           items[i][1] = Integer.parseInt(st.nextToken());
       }

       for(int i=1; i<=N; i++) {
           int hp = items[i][0];
           int happy = items[i][1];

           for(int j=100; j>=hp; j--) {
               dp[j] = Math.max(dp[j], dp[j - hp] + happy);
           }
       }

       int max = 0;
       for(int i=0; i<100; i++) {
           max = Math.max(max, dp[i]);
       }

        System.out.println(max);
    }
}
