package DynamicProgramming;

import java.util.Scanner;

public class BOJ2193 {
    // 점화식의 형태
    // D[i][0] : i 길이에서 끝이 0으로 끝나는 이친수의 개수
    // D[i][1] : i 길이에서 끝이 1으로 끝나는 이친수의 개수
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int jarisu = scanner.nextInt();

        long[][] D = new long[jarisu+1][2]; // 점화식 배열 초기화

        D[1][0] = 0;
        D[1][1] = 1;

        for(int i=2; i<=jarisu; i++) {
            D[i][0] = D[i-1][1] + D[i-1][0];
            D[i][1] = D[i-1][0];
        }

        System.out.println(D[jarisu][0] + D[jarisu][1]);
    }
}
