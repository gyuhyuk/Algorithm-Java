package Greedy;

import java.util.*;

public class BOJ15557 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        ArrayList<Double> arrayList = new ArrayList<>();
        Deque<Double> deque = new LinkedList<>();

        for(int i=0; i<N; i++) {
            arrayList.add(scanner.nextDouble());
        }
        Collections.sort(arrayList);

        deque.addAll(arrayList);


        for(int i=0; i<N-1; i++) {
            Double temp1 = deque.poll();
            Double temp2 = deque.poll();
            deque.addFirst((temp1+temp2)/2);
        }

        System.out.println(deque.poll());
    }
}