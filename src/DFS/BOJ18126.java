package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ18126 {
    static int N;
    static boolean[] visited;
    static ArrayList<Node>[] A;
    static long max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            A[start].add(new Node(end, value));
            A[end].add(new Node(start, value));
        }

        visited[1] = true;
        dfs(1, 0);

        System.out.println(max);
    }

    static void dfs(int node, long dist) {
        max = Math.max(max, dist);

        for(Node next : A[node]) {
            if(!visited[next.x]) {
                visited[next.x] = true;
                dfs(next.x, dist + next.value);
            }
        }
    }

    static class Node {
        int x;
        int value;

        public Node(int x, int value) {
            this.x = x;
            this.value = value;
        }
    }
}
