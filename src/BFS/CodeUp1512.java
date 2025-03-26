package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeUp1512 {
    static int[][] A;
    static boolean[][] visited;
    static int N, X, Y;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        A[X][Y] = 1; // X, Y 첫 좌표는 1

        BFS(X, Y);

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void BFS(int x, int y) {
        visited[x][y] = true;
        Queue<MyMap> queue = new LinkedList<>();
        queue.add(new MyMap(x, y));

        while (!queue.isEmpty()) {
            MyMap now = queue.poll();
            int newX = now.x;
            int newY = now.y;

            for(int i=0; i<4; i++) {
                int nx = newX + dx[i];
                int ny = newY + dy[i];

                if(nx > 0 && ny > 0 && nx <= N && ny <= N && !visited[nx][ny]) {
                    queue.add(new MyMap(nx, ny));
                    visited[nx][ny] = true;
                    A[nx][ny] = A[newX][newY] + 1;
                }
            }
        }
    }

    static class MyMap {
        int x;
        int y;

        public MyMap(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
