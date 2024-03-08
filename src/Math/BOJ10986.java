package Math;

import java.io.IOException;
import java.util.Scanner;

public class BOJ10986 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long answer = 0;

        long[] arr = new long[N];
        long[] sumArr = new long[N];
        long[] remainderArr = new long[M];

        for(int i=0; i<N; i++) {
            arr[i] = scanner.nextInt();
        }

        sumArr[0] = arr[0];

        for(int i=1; i<N; i++) {
            sumArr[i] = arr[i] + sumArr[i-1];
        }

        for(int i=0; i<N; i++) {
            sumArr[i] %= M;
        }

        for(int i=0; i<N; i++) {
            int remain = (int) (sumArr[i] % M);
            if(remain == 0) {
                answer++;
            }
            remainderArr[remain]++;
        }

        for(int i=0; i<M; i++) {
            if(remainderArr[i] > 1) {
                answer = answer + (remainderArr[i] * (remainderArr[i]-1) / 2);
            }
        }

        System.out.println(answer);

    }
}
