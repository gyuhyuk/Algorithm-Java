package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24445 {
    static int N, M, R;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = new int[N+1];
        Arrays.fill(answer, 0);

        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
        }

        for(int i=1; i<=N; i++) {
            A[i].sort(Collections.reverseOrder());
        }

        bfs(R);

        for(int i=1; i<A.length; i++) {
            System.out.println(answer[i]);
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        int count = 1;
        answer[node] = count;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i : A[temp]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    answer[i] = ++count;
                }
            }
        }
    }
}
