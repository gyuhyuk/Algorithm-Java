package Greedy;

import java.util.Scanner;

public class BOJ30404 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int last = 0;
        int clap = 0;

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            if (i == 0) last = x;

            if (last + K < x) {
                clap++;
                last = x;
            }
        }

        System.out.println(clap + 1);

        scanner.close();
    }
}
