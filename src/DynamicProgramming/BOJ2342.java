package DynamicProgramming;

import java.util.Scanner;

public class BOJ2342 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // DP 테이블 [N][L][R]
        int[][][] DP = new int[100001][5][5];

        // 한 발을 이동할 때 드는 힘 (mp[1][2] -> 1에서 2로 이동할 때 드는 힘)
        int[][] mp = {  {0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1},
        };

        int n = 0;
        int s = 1;

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                for(int k=0; k<100001; k++) {
                    DP[k][i][j] = 100001 * 4;
                }
            }
        }

        DP[0][0][0] = 0;

        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }

            for(int i=0; i<5; i++) {
                if (n == i) {
                    continue;
                }
                for(int j=0; j<5; j++) {
                    DP[s][i][n] = Math.min(DP[s-1][i][j] + mp[j][n], DP[s][i][n]);
                }
            }

            for(int j=0; j<5; j++) {
                if(n == j) {
                    continue;
                }
                for(int i=0; i<5; i++) {
                    DP[s][n][j] = Math.min(DP[s-1][i][j] + mp[i][n], DP[s][n][j]);
                }
            }
            s++;
        }
        s--;

        int min = Integer.MAX_VALUE;

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                min = Math.min(min, DP[s][i][j]);
            }
        }
        System.out.println(min);
    }
}
