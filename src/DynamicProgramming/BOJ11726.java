package DynamicProgramming;

import java.util.Scanner;

public class BOJ11726 {
    // 모듈러 연산하는 위치를 잘 생각할 것
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] D = new long[1001];

        D[1] = 1;
        D[2] = 2;

        for(int i=3; i<=n; i++) {
            D[i] = (D[i-1] + D[i-2]) % 10007;
        }

        System.out.println(D[n]);
    }
}
