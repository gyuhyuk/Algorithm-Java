package Greedy;

import java.util.Scanner;

public class BOJ24938 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long sum = 0;
        long answer = 0;

        long[] arr = new long[N];

        for(int i=0; i<N; i++) {
            arr[i] = scanner.nextLong();
            sum += arr[i];
        }

        long avg = sum / N;
        long temp = 0;

        for(int i=0; i<arr.length; i++) {
            long diff = arr[i] + temp - avg;
            temp = diff;
            answer += Math.abs(diff);
        }

        System.out.println(answer);
    }
}

