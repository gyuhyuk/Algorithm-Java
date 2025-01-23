package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ24480 {
    static int[] answer;
    static int N, M, R;
    static int count = 0;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = new int[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
        }

        for(int i=1; i<=N; i++) {
            A[i].sort(Collections.reverseOrder());
        }


        DFS(R);
        for(int i=1; i<=N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        answer[node] = ++count;

        for(int i : A[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
