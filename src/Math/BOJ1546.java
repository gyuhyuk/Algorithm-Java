package Math;

import java.util.Scanner;

public class BOJ1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int user = scanner.nextInt();
        int[] arr = new int[user];

        for(int i=0; i<user; i++) {
            arr[i] = scanner.nextInt();
        }

        long sum = 0;
        long max = 0;

        for(int i=0; i<user; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }

        System.out.println(sum*100.0 / max / user);
    }
}
