package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    static int[][] A;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for(int i=0; i<N; i++) {
             st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if(A[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && A[nx][ny] == 0) {
                    A[nx][ny] = A[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int max = Integer.MIN_VALUE;

        if(checkZero()) {
            return -1;
        } else {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(max < A[i][j]) {
                        max = A[i][j];
                    }
                }
            }
        }

        return max - 1;
    }

    static boolean checkZero() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(A[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
