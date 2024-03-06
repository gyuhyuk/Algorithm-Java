package Math;

import java.util.Scanner;

public class BOJ11659 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int data = scanner.nextInt();
        int question = scanner.nextInt();

        long[] arr = new long[data+1];

        arr[0] = 0;

        for(int i=1; i<=data; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i=1; i<=data; i++) {
            arr[i] = arr[i] + arr[i-1];
        }

        for(int i=0; i<question; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            System.out.println(arr[end] - arr[start-1]);
        }
    }
}
