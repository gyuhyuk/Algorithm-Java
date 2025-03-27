package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24447 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int N, M, R;
    static long[] depthArr;
    static long[] order;
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        depthArr = new long[N+1];
        order = new long[N+1];

        Arrays.fill(depthArr, -1);

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
            Collections.sort(A[i]); // 오름차순
        }

        BFS(R);

        for(int i=1; i<A.length; i++) {
            answer += order[i] * depthArr[i];
        }

        System.out.println(answer);
    }
    static void BFS(int start) {
        visited[start] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        depthArr[start] = 0;

        int count = 1;
        order[start] = count;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowNode = now[0];
            int depth = now[1];

            for(int next : A[nowNode]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth+1});
                    depthArr[next] = depth+1;
                    order[next] = ++count;
                }
            }
        }
    }
}
