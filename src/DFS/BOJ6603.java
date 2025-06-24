package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    static int K;
    static boolean[] visited;
    static int[] arr;
    static int[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if(K == 0) {
                break;
            }

            S = new int[K];

            for(int i=0; i<K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[K];
            arr = new int[6];

            DFS(0, 0);
            System.out.println();
        }
    }

    static void DFS(int start, int depth) {
        if(depth == 6) {
            for(int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i<K; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = S[i];
                DFS(i, depth+1);
                visited[i] = false;
            }
        }
    }
}
