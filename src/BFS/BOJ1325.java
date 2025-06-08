package BFS;

import java.io.*;
import java.util.*;

public class BOJ1325 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 역방향 간선 저장: B -> A (A가 B를 해킹할 수 있다)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        for (int i = 1; i <= N; i++) {
            BFS(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    static void BFS(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    result[next]++;
                    queue.add(next);
                }
            }
        }
    }
}
