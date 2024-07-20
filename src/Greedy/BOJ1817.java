package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1817 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            arr.add(scanner.nextInt());
        }

        int count = 1;

        if(N == 0) {
            System.out.println(0);
            return;
        }

        int weight = 0;

        for(int i=0; i<N; i++) {
            weight += arr.get(i);
            if(weight > M) {
                count++;
                weight = arr.get(i);
            }
        }

        System.out.println(count);
    }
}
