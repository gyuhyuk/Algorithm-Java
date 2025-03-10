package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[400001];
        int[] dp = new int[400001];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>=1; i--) {
            dp[i] = dp[i + arr[i] + 1] + 1;
        }

        for(int i=1; i<=N; i++) {
            sb.append(dp[i]).append(" ");
        }

        System.out.println(sb);
    }
}
