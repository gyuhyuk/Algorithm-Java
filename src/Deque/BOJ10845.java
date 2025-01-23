package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령의 수
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine(); // 한 줄 입력
            String[] command = input.split(" "); // 공백 기준으로 나누기

            if (command[0].equals("push")) { // push 명령 처리
                int num = Integer.parseInt(command[1]);
                deque.add(num);
            }
            else if (command[0].equals("front")) { // front 명령 처리
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            }
            else if (command[0].equals("back")) { // back 명령 처리
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peekLast()).append("\n");
                }
            }
            else if (command[0].equals("size")) { // size 명령 처리
                sb.append(deque.size()).append("\n");
            }
            else if (command[0].equals("empty")) { // empty 명령 처리
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            }
            else if (command[0].equals("pop")) { // pop 명령 처리
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            }
        }

        System.out.println(sb); // 결과 출력
    }
}