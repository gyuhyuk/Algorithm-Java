package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA7465 {
    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testcase = Integer.parseInt(st.nextToken());

        for(int t=1; t<=testcase; t++) {
            st = new StringTokenizer(br.readLine());
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

                A[start].add(end);
                A[end].add(start);
            }

            int result = 0;

            for(int i=1; i<=N; i++) {
                if(!visited[i]) {
                    DFS(i);
                    result++;
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }

    static void DFS(int node) {
        visited[node] = true;

        for(int i : A[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
