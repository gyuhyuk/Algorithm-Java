package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ31872 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> ansArr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            arr.add(scanner.nextInt());
        }
        Collections.sort(arr);

        ansArr.add(arr.get(0));
        for(int i=0; i<N-1; i++) {
            ansArr.add(arr.get(i+1)-arr.get(i));
        }

        Collections.sort(ansArr);

        for(int i=0; i<ansArr.size()-K; i++) {
            answer += ansArr.get(i);
        }

        System.out.println(answer);
    }
}
