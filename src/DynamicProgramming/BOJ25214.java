package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int user = Integer.parseInt(st.nextToken());
        int[] A = new int[user+1];
        int[] dp = new int[user+1];
        dp[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=user; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int min = A[1];

        for(int i=1; i<=user; i++) {
            min = Math.min(A[i], min);
            dp[i] = Math.max(dp[i-1], A[i] - min);
        }

        for(int i=1; i<=user; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
