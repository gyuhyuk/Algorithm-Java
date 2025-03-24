package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24446 {
    static int N, M, R;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = new int[N+1];

        Arrays.fill(answer, -1);

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

        BFS(R);

        for(int i=1; i<answer.length; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void BFS(int start) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(new int[]{start, 0});
        answer[start] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowNode = now[0];
            int depth = now[1];

            for(int next : A[nowNode]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth+1});
                    answer[next] = depth+1;
                }
            }
        }
    }
}
