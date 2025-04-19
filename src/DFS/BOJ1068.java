package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1068 {
    static int N;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int answer;
    static int deleteNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        visited = new boolean[N];

        int root = -1;

        for(int i=0; i<N; i++) {
            A[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p == -1) {
                root = i;
            } else {
                A[p].add(i);
                A[i].add(p);
            }
        }
        st = new StringTokenizer(br.readLine());
        deleteNode = Integer.parseInt(st.nextToken());

        if(deleteNode == root) {
            System.out.println(0);
            return;
        } else {
          DFS(root);
        }
        System.out.println(answer);
    }

    static void DFS(int node) {
        visited[node] = true;

        int nodes = 0;
        for(int next : A[node]) {
            if(next != deleteNode && !visited[next]) {
                nodes++;
                DFS(next);
            }
        }

        if(nodes == 0) {
            answer++;
        }
    }
}
