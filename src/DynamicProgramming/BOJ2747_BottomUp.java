package DynamicProgramming;

import java.util.Scanner;

public class BOJ2747_BottomUp {
    static int[] DP;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        DP = new int[n+1];
        for(int i=0; i<=n; i++) {
            DP[i] = -1;
        }

        DP[0] = 0;
        DP[1] = 1;

        for(int i=2; i<=n; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }

        System.out.println(DP[n]);
    }
}
