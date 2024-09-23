package Math;

import java.util.Scanner;

public class BOJ1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;

        for(int i=1; i<=N; i++) {
            int now = i;
            while (now % 5 == 0) { // i의 소인수 중에 5가 있을 때까지 반복
                count++;
                now /= 5;
            }
        }

        System.out.println(count);
    }
}
