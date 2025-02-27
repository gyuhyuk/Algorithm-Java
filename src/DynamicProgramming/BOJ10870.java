package DynamicProgramming;

import java.util.Scanner;

public class BOJ10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] fib = new int[21];

        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;

        for(int i=3; i<=20; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        System.out.println(fib[N]);
    }
}
