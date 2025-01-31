package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16947 {
    static ArrayList<Integer>[] A;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;
    static boolean isCycle;
    static int N;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];

        Arrays.fill(distance, -1);

        for(int i=1; i<=N; i++) { // A 배열 초기화
            A[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++) { // 양방향 연결
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
        }

        dfs(A, 0, 1);
        bfs(A);

        for(int i=1; i<=N; i++) {
            sb.append(distance[i]).append(" ");
        }
        System.out.println(sb);
    }
    static void bfs(ArrayList<Integer>[] arr) {
        int count = 1;

        while (!queue.isEmpty()) {
            int tmp = queue.size();
            for(int i=0; i<tmp; i++) {
                int node = queue.poll();
                for(int j : arr[node]) {
                    if(distance[j] != -1) {
                        continue;
                    }
                    distance[j] = count;
                    queue.add(j);
                }
            }
            count++;
        }
    }

    static void dfs(ArrayList<Integer>[] arr, int prev, int curr) {
        visited[curr] = true; // 방문한 곳 check
        for(int next : arr[curr]) { // 연결된 곳 모두 탐색
            if(visited[next] && next != prev) { // 직전 방문지가 아니면서 이미 방문한 곳이면 -> 싸이클이 돌은 것
                isCycle = true;
                distance[next] = 0;
                queue.add(next);
                break;
            }
            else if (!visited[next]) {
                dfs(arr, curr, next);

                if(isCycle) {
                    if(distance[next] == 0) {
                        isCycle = false;
                    }
                    else {
                        distance[next] = 0;
                        queue.add(next);
                    }
                    return;
                }
            }
        }
    }
}
