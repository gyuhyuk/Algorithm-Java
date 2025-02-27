package Math;

import java.util.Scanner;

public class BOJ10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long res = 1;

        if(n == 0) {
            System.out.println(1);
        } else {
            for(int i=1; i<=n; i++) {
                res *= i;
            }
            System.out.println(res);
        }
    }
}
