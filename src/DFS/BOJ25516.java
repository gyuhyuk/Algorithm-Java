package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ25516 {
    static int N, K;
    static int[] apple;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        apple = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            A[i] = new ArrayList<>(); // A 배열 초기화
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end); // 단방향 저장
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            apple[i] = Integer.parseInt(st.nextToken()); // 사과 개수
        }

        dfs(0, 0);

        System.out.println(result);
    }

    static void dfs(int node, int depth) {
        if(depth > K) {
            return;
        }
        result += apple[node];
        visited[node] = true;

        for(int i : A[node]) {
            if(!visited[i]) {
                dfs(i, depth+1);
            }
        }
    }
}
