package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14496 {
    static int A, B, N, M;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1]; // 초기화
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start].add(end); // 양방향
            arr[end].add(start); // 양방향
        }

        System.out.println(BFS(A));
    }

    static int BFS(int start) {
        visited[start] = true;
        Queue<int[]> queue = new LinkedList<>(); // 배열 형태로 queue 생성
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int now = curr[0]; // node
            int cost = curr[1]; // value

            if(now == B) {
                return cost;
            }

            for(int i : arr[now]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, cost+1});
                }
            }
        }
        return -1; // 도달 못하면 -1 return
    }
}
