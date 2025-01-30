package Math;

import java.util.Scanner;

public class BOJ5341 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        while(true) {
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }
            sb.append(n*(n+1)/2).append("\n");
        }
        System.out.println(sb);
    }
}
