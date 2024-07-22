package BinarySearch;

import java.util.Scanner;

public class BOJ1300 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long start = scanner.nextLong(); // 시작점
        long end = scanner.nextLong(); // 끝점

        long[] A = new long[10000001]; // 배열 선언
        for(int i=2; i<A.length; i++) { // 2부터 배열의 길이까지
            A[i] = i; // 각각의 숫자 대입
        }

        for(int i=2; i<Math.sqrt(A.length); i++) { //
            if(A[i] == 0) {
                continue;
            }
            for(int j = i + i; j<A.length; j = j + i) {
                A[j] = 0;
            }
        }

        int count = 0;

        for(int i=2; i<A.length; i++) {
            if(A[i] != 0) {
                long temp = A[i];
                while ((double)A[i] <= (double) end/(double) temp) {
                    if((double)A[i] >= (double) start / (double) temp) {
                        count++;
                    }
                    temp = temp * A[i];
                }
            }
        }

        System.out.println(count);
    }
}
