package Implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ10811 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr;
        arr = new int[N+1];
        int temp = 0;

        for(int i=1; i<=N; i++) {
            arr[i] = i;
        }

        for(int i=0; i<M; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            while (start < end) {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        for(int i=1; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
