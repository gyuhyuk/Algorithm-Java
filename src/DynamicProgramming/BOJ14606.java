package DynamicProgramming;

import java.util.Scanner;

public class BOJ14606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(0);
        }

        else {
            System.out.println((n-1)*n/2);
        }
    }
}
