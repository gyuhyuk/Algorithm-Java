package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238 {
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t=1; t<=10; t++) {
            st = new StringTokenizer(br.readLine());

            int len = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());

            A = new ArrayList[101];

            for(int i=1; i<=100; i++) {
                A[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<len/2; i++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                A[start].add(end);
            }

            int result = BFS(startNode);

            System.out.println("#" + t + " " + result);
        }
    }

    static int BFS(int node) {
        Queue<int[]> queue = new LinkedList<>();

        boolean[] visited = new boolean[101];

        queue.add(new int[]{node, 0});
        visited[node] = true;

        int maxDepth = 0;
        int maxNode = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowNode = now[0];
            int nowDepth = now[1];

            if (nowDepth > maxDepth) {
                maxDepth = nowDepth;
                maxNode = nowNode;
            } else if (maxDepth == nowDepth) {
                maxNode = Math.max(maxNode, nowNode);
            }

            for (int i : A[nowNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, nowDepth + 1});
                }
            }
        }
        return maxNode;
    }
}
