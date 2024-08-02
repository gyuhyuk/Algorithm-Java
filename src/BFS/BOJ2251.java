package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2251 {
    // 6가지 이동 케이스를 표현하기 위한 배열
    // 0번은 A, 1번은 B, 2번은 C 물통을 의미함
    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited; // 방문 배열 (A, B의 무게만 있으면 C의 무게는 정해진다.)
    static boolean[] answer; // 가능한 C의 물의 양을 저장하는 배열
    static int[] now; // A,B,C 값을 저장하는 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        now = new int[3]; // A, B, C 물의 양을 저장하는 배열
        now[0] = Integer.parseInt(s[0]);
        now[1] = Integer.parseInt(s[1]);
        now[2] = Integer.parseInt(s[2]);

        visited = new boolean[201][201];
        answer = new boolean[201];

        BFS();

        for (int i=0; i<answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;

            int C = now[2] - A - B; // C는 전체 물의 양에서 A와 B를 뺀 것

            for(int k = 0; k<6; k++) { // A -> B, A -> C, B -> A, B -> C, C -> A, C -> B
                int[] next = {A, B, C};
                next[Receiver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;
                if(next[Receiver[k]] > now[Receiver[k]]) { // 물이 넘칠 때
                    // 초과하는 만큼 다시 이전 물통에 넣어준다.
                    next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]];
                    next[Receiver[k]] = now[Receiver[k]]; // 대상 물통은 최대로 채워준다.
                }

                if(!visited[next[0]][next[1]]) { // A와 B의 물의 양을 이용해 방문 배열 체크
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if(next[0] == 0) { // A의 물의 양이 0일 때 C의 물의 무게를 정답 변수에 저장
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}

// AB 클래스 선언 -> A와 B의 값만 지니고 있으면 C는 유추할 수 있으므로 두 변수만 사용한다.
class AB {
    int A;
    int B;

    public AB(int a, int b) {
        A = a;
        B = b;
    }
}