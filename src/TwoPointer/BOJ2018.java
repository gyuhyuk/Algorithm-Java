package TwoPointer;

import java.util.Scanner;

public class BOJ2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int startIndex = 1;
        int endIndex = 1;
        int cnt = 1;
        int sum = 1;

        while (endIndex != N) {
            if (sum == N) {
                cnt++;
                endIndex++;
                sum += endIndex;
            } else if (sum > N) {
                sum -= startIndex;
                startIndex++;
            }
            else {
                endIndex++;
                sum += endIndex;
            }
        }
        System.out.println(cnt);
    }
}
