package DynamicProgramming;

import java.util.Scanner;

public class BOJ9656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n%2 == 0) {
            System.out.println("SK");
        }
        else {
            System.out.println("CY");
        }
    }
}
