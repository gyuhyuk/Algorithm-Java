package DynamicProgramming;

import java.util.Scanner;

public class BOJ2747_TopDown {
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
        fibo(n);
        System.out.println(DP[n]);
    }

    static int fibo(int n) {
        if(DP[n] != -1) {
            return DP[n];
        }
        return DP[n] = fibo(n-2) + fibo(n-1);
    }
}
