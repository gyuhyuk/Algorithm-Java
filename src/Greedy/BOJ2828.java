package Greedy;

import java.util.Scanner;

public class BOJ2828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int J = scanner.nextInt();

        int left = 1;
        int right = M;
        int distance = 0;

        int now = scanner.nextInt();
        if(now > M) {
            distance += now - M;
            right = now;
            left = now - (M-1);
        }

        for(int i=0; i<J-1; i++) {
            int next = scanner.nextInt();
            if(next > now && next > right) {
                distance += next - right;
                right = next;
                left = next - (M-1);
            } else if (next < now && next < left) {
                distance += left - next;
                right = next + (M-1);
                left = next;
            }
            now = next;
        }

        System.out.println(distance);
    }
}
