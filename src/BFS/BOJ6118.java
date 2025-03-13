package BFS;

import java.io.*;
import java.util.*;

public class BOJ6118 {
    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
        }

        bfs(1);
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        int maxDistance = 0;
        int[] distance = new int[N + 1];
        int furthestNode = 0;
        int count = 0;

        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : A[current]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                }
            }
        }

        // 최대 거리 노드 찾기
        for (int i = 1; i <= N; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                furthestNode = i;
                count = 1; // 새로운 최대 거리 노드 발견 시 초기화
            } else if (distance[i] == maxDistance) {
                count++; // 같은 거리의 노드가 있으면 증가
            }
        }

        System.out.println(furthestNode + " " + maxDistance + " " + count);
    }
}
