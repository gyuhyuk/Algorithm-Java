package Math;

import java.util.Scanner;

public class BOJ1057 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int cnt = 0;

        while(true) {
            cnt++;
            A = (A+1)/2;
            B = (B+1)/2;

            if(A==B) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
