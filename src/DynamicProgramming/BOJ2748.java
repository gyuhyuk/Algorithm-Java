package DynamicProgramming;

import java.util.Scanner;

public class BOJ2748 {
    static long[] fib;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int n = sc.nextInt();
        fib = new long[91];
        fib[0] = 0;
        fib[1] = 1;

        for(int i=2; i<=90; i++) {
            fib[i] = fib[i-1] + fib[i-2];
            count++;
            if(i == n) {
                sb.append(fib[i]).append(" ");
                sb.append(count-1);
            }
        }
        System.out.println(sb);
    }
}
