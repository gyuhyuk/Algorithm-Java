package Deque;

import java.util.*;

public class BOJ13417 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> deque = new LinkedList<>();

        int N = scanner.nextInt();

        for(int i=0; i<N; i++) {
            int user = scanner.nextInt();
            for(int j=0; j<user; j++) {
                String s = scanner.next();
                if(deque.isEmpty()) {
                    deque.add(s);
                }
                else {
                    if(s.compareTo(deque.getFirst()) <= 0) {
                        deque.addFirst(s);
                    }
                    else {
                        deque.addLast(s);
                    }
                }
            }
            while(!deque.isEmpty()) {
                System.out.print(deque.pollFirst());
            }
            System.out.println();
        }

    }
}
