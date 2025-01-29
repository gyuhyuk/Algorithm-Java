package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1328 {
    static long mod = 1000000007;
    static int N, L, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 빌딩 수
        L = Integer.parseInt(st.nextToken()); // 왼쪽
        R = Integer.parseInt(st.nextToken()); // 오른쪽

        long[][][] DP = new long[101][101][101];
        DP[1][1][1] = 1;

        for(int i=2; i<=N; i++) {
            for(int j=1; j<=L; j++){
                for(int k=1; k<=R; k++) {
                    DP[i][j][k] = (DP[i-1][j][k] * (i-2) + (DP[i-1][j][k-1] + DP[i-1][j-1][k])) % mod;
                }
            }
        }

        System.out.println(DP[N][L][R]);
    }
}
