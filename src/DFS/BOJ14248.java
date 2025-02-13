package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14248 {
    static int N, S;
    static int[] arr;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        visited = new boolean[N+1];
        result = 1;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        visited[S] = true;
        dfs(S);

        System.out.println(result);
    }

    static void dfs(int start) {
        int front = start - arr[start]; // 앞
        int back = start + arr[start]; // 뒤

        if(back <= N && !visited[back]) {
            visited[back] = true;
            result++;
            dfs(back);
        }
        if(front > 0 && !visited[front]) {
            visited[front] = true;
            result++;
            dfs(front);
        }
    }
}
