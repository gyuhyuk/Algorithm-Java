package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for(int i=0; i<K-1; i++) {
                queue.add(queue.poll());
            }
            arrayList.add(queue.poll());
        }

        System.out.print("<");

        for(int i=0; i<arrayList.size()-1; i++) {
            System.out.print(arrayList.get(i) + ", ");
        }

        System.out.print(arrayList.get(arrayList.size()-1));

        System.out.print(">");
    }
}
