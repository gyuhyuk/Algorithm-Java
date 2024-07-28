package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ30018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        int answer = 0;

        int N = scanner.nextInt();
        for(int i=0; i<N; i++) {
            arr1.add(scanner.nextInt());
        }
        for(int i=0; i<N; i++) {
            arr2.add(scanner.nextInt());
        }

        for(int i=0; i<N; i++) {
            if((arr1.get(i) - arr2.get(i)) > 0) {
                continue;
            }
            else {
                answer += (arr2.get(i) - arr1.get(i));
            }
        }

        System.out.println(answer);
    }
}
