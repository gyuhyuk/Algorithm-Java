package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ21937 {
    static int N, M, X;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[end].add(start);
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());

        DFS(X);

        System.out.println(count);
    }

    static void DFS(int node) {
        visited[node] = true;

        for(int i : A[node]) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
    }
}
