package BFS;

import java.util.*;

public class BOJ1389 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int[] dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        int min_count = Integer.MAX_VALUE;
        int min_index = 0;

        for(int i=1; i<=N; i++) {
            int count = BFS(i);
            if(min_count > count) {
                min_count = count;
                min_index = i;
            }
        }

        System.out.println(min_index);
    }

    private static int BFS(int start) {
        Arrays.fill(dist, -1);
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            for(int i : A[now_Node]) {
                if (dist[i] != -1) {
                    continue;
                }
                dist[i] = dist[now_Node] + 1;
                count += dist[i];
                queue.add(i);
            }
        }
        return count;
    }
}
