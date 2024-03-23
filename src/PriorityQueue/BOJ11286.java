package PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11286 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if(first == second) {
                return o1 > o2 ? 1 : -1;
            }
            else {
                return first - second;
            }
        });

        for(int i=0; i<N; i++) {
            int x = scanner.nextInt();

            if(x == 0) {
                if (queue.isEmpty()) {
                    System.out.println("0");
                }
                else {
                    System.out.println(queue.poll());
                }
            }
            else {
                queue.add(x);
            }

        }
    }
}
