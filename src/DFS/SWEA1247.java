package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1247 {
    static int N, min;
    static ArrayList<int[]> arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            arr = new ArrayList<>();
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<N+2; i++) { // 회사, 집, 고객 순
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                arr.add(new int[]{A, B});
            }

            visited = new boolean[N]; // 고객 수만큼 visited
            min = Integer.MAX_VALUE;

            DFS(0, 0, 0);

            System.out.println("#" + t + " " + min);
        }
    }

    static void DFS(int depth, int currIndex, int distSum) {
        if(distSum >= min) {
            return;
        }

        if(depth == N) {
            int[] curr = arr.get(currIndex);
            int[] home = arr.get(1);
            min = Math.min(min, distSum + distance(curr, home));
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int nextIndex = i + 2;
                int[] curr = arr.get(currIndex);
                int[] next = arr.get(nextIndex);

                DFS(depth+1, nextIndex, distSum + distance(curr, next));

                visited[i] = false;
            }
        }
    }

    static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
