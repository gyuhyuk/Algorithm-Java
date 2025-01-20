package Greedy;

import java.util.Scanner;

public class BOJ32173 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long sum = 0;
        long max = Long.MIN_VALUE;
        long temp = 0;

        for(long i=0; i<N; i++) {
            long x = sc.nextLong();
            if(x - sum > temp) {
                max = x - sum;
                sum += x;
                temp = max;
            }
            else {
                max = temp;
                sum += x;
            }
        }

        System.out.println(max);
    }
}
