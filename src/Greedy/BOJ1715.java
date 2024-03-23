package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            queue.add(sc.nextInt());
        }

        while (queue.size() > 1) {
            int first = queue.remove();
            int second = queue.remove();

            answer = answer + first + second;

            queue.add(first + second);
        }

        System.out.println(answer);
    }
}
