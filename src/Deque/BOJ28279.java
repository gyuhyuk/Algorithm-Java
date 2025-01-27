package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if(command == 1) {
                int x = Integer.parseInt(st.nextToken());
                deque.addFirst(x);
            }
            else if (command == 2) {
                int x = Integer.parseInt(st.nextToken());
                deque.addLast(x);
            }
            else if (command == 3) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            }
            else if (command == 4) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(deque.pollLast()).append("\n");
                }
            }
            else if (command == 5) {
                sb.append(deque.size()).append("\n");
            }
            else if (command == 6) {
                if(deque.isEmpty()) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            else if (command == 7) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            }
            else if (command == 8) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
