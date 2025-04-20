package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    static int N, K;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = BFS(N);
        System.out.println(result);
    }

    static int BFS(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int time = current[1];

            if (pos == K) {
                return time;
            }

            if(pos-1>=0 && !visited[pos-1]) {
                visited[pos-1] = true;
                queue.add(new int[]{pos-1, time+1});
            }
            if(pos+1<=100000 && !visited[pos+1]) {
                visited[pos+1] = true;
                queue.add(new int[]{pos+1, time+1});
            }
            if(2*pos <= 100000 && !visited[2*pos]) {
                visited[2*pos] = true;
                queue.add(new int[]{2*pos, time+1});
            }
        }

        return -1;
    }
}
