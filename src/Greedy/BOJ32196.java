package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ32196 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Long> arr = new ArrayList<>();

        long N = sc.nextLong();
        long M = sc.nextLong();
        long K = sc.nextLong();
        long X = sc.nextLong();
        long Y = sc.nextLong();

        long sum = 0;

        for(long i=0; i<N; i++) {
            long A = sc.nextLong();
            long B = sc.nextLong();

            arr.add(A*X-B*Y);
        }

        Collections.sort(arr);

        for(int j=0; j<M; j++) {
            sum += arr.get(j);
        }

        sum += K*(X+Y);

        System.out.println(sum);
    }
}
