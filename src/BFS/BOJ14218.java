package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14218 {
    static int n, m, q;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1]; // 인덱스 1부터
        visited = new boolean[n+1]; // 인덱스 1부터
        answer = new int[n+1]; // 인덱스 1부터

        for(int i=1; i<=n; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) { // 3번 반복
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end); // 양방향
            A[end].add(start); // 양방향
        }

        q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++) {
            Arrays.fill(answer, -1); // -1로 초기화
            visited = new boolean[n+1];

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
            BFS(1);
            System.out.print("0 "); // 수도는 1번도시
            for(int j=2; j<answer.length; j++) { // 2번부터 출력
                System.out.print(answer[j] + " ");
            }
            System.out.println();
        }

    }
    static void BFS(int start) {
        visited[start] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0}); // 1번 노드

        while (!queue.isEmpty()) {
            int[] now = queue.poll(); // now = 1
            int nowNode = now[0];
            int depth = now[1];

            for(int i : A[nowNode]) { // 순회
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, depth+1});
                    answer[i] = depth+1;
                }
            }
        }

    }
}
