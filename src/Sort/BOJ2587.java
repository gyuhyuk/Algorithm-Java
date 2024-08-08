package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2587 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        int sum = 0;

        for(int i=0; i<5; i++) {
            int n = scanner.nextInt();
            arr.add(n);
            sum += n;
        }

        Collections.sort(arr);

        System.out.println(sum/5);
        System.out.println(arr.get(2));
    }
}
