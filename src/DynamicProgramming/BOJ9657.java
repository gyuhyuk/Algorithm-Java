package DynamicProgramming;

import java.util.Scanner;

public class BOJ9657 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n % 7 == 0 || n % 7 == 2) {
            System.out.println("CY");
        }
        else {
            System.out.println("SK");
        }
    }
}
