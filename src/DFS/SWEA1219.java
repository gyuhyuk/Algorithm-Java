package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1219 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t=1; t<=10; t++) {
            st = new StringTokenizer(br.readLine());
            int testcase = Integer.parseInt(st.nextToken());
            int user = Integer.parseInt(st.nextToken());

            A = new ArrayList[100];
            visited = new boolean[100];

            for (int i = 0; i < 100; i++) {
                A[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<user; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                A[from].add(to); // 방향 그래프
            }

            isPossible = false;
            dfs(0);
            System.out.println("#" + testcase + " " + (isPossible ? 1 : 0));
        }
    }

    static void dfs(int node) {
        if (node == 99) { // 도착점
            isPossible = true;
            return;
        }

        visited[node] = true;

        for (int next : A[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
