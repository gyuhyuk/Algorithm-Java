package Greedy;

import java.util.Scanner;

public class BOJ20363 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        int min = Math.min(X, Y);

        int answer = 0;
        answer = X + Y;

        answer += min / 10;

        System.out.println(answer);
    }
}
