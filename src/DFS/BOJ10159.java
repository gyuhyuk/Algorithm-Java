package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ10159 {
    static int[] answer;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // M

        answer = new int[N+1]; // 정답 배열
        A = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
        }

        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1]; // 방문 배열
            visited[i] = true;
            DFS(i, i, 0);
        }

        for(int i=1; i<=N; i++) {
            System.out.println(N - answer[i]);
        }
    }

    private static void DFS(int index, int root, int value) {
        answer[index]++;

        for(int i : A[index]) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            answer[root]++;
            DFS(i, root, value);
        }
    }
}
