package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5567 {
    static int n, m;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        A = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++) {
            A[i] = new ArrayList<>();
        }

        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        BFS(1, 0);

        int ans = 0;
        for(int i=2; i<=n; i++) {
            if(visited[i]) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static void BFS(int node, int depth) {
        if(depth == 2) {
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for(int i : A[x]) {
                visited[i] = true;
                BFS(i, depth+1);
            }

        }
    }
}
