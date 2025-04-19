package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086 {
    static int N, M, answer;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {-1, 1, -1, 0, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    answer = Math.max(answer, BFS(i ,j));
                }
            }
        }

        System.out.println(answer);
    }

    static int BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});

        visited = new boolean[N][M];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now  = queue.poll();

            for(int i=0; i<8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int dist = now[2] + 1;

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] == 1) {
                    return dist;
                }
                queue.offer(new int[]{nx, ny, dist});
                visited[nx][ny] = true;
            }
        }

        return 0;
    }
}
