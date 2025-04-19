package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ16964 {
    static int N;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] user;
    static int result = 1;
    static int index = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        user = new int[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            user[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1);

        System.out.println(result);
    }

    static void DFS(int node) {
        visited[node] = true;
        HashSet<Integer> set = new HashSet<>();
        for(int next : A[node]) {
            if (!visited[next]) {
                set.add(next);
            }
            }

            if(set.isEmpty()) {
                return;
            }

            if(set.contains(user[index])) {
                DFS(user[index++]);
            } else {
                result = 0;
            }
    }
}
