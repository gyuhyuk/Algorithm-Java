package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] A;
    static boolean[][] visited;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        answer = new int[N][M];
        visited = new boolean[N][M];
        int x = 0, y = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if(A[i][j] == 2) {
                    x = i;
                    y = j;
                } else if (A[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        BFS(x, y);

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j]) {
                    answer[i][j] = -1;
                }
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void BFS(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();

            for(int i=0; i<4; i++) { // 상하좌우
                int nx = nowNode[0] + dx[i];
                int ny = nowNode[1] + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && A[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    answer[nx][ny] = answer[nowNode[0]][nowNode[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
