package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ24483 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int N, M, R;
    static long[] answer;
    static long result = 0;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = new long[N+1];

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

        for(int i=1; i<=N; i++) {
            Collections.sort(A[i]);
        }

        dfs(R, 0);

        System.out.println(result);
    }

    static void dfs(int x, int depth) {
        visited[x] = true;
        answer[x] = depth;

        result += (long) answer[x] * count;
        count++;

        for(int i : A[x]) {
            if(!visited[i]) {
                dfs(i, depth+1);
            }
        }
    }
}
