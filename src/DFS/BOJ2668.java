package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2668 {
    static int N;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i].add(Integer.parseInt(st.nextToken()));
        }

        for(int i=1; i<=N; i++) {
            Arrays.fill(visited, false);
            DFS(i, i);
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for(int i : answer) {
            System.out.println(i);
        }
    }

    static void DFS(int node, int target) {
        visited[node] = true;

        for(int next : A[node]) {
            if(!visited[next]) {
                DFS(next, target);
            } else if (next == target) {
                answer.add(next);
            }
        }
    }
}
