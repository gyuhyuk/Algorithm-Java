package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2573 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] A;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int count = 0;

        while ((count = SeparateNum()) < 2) {
            if (count == 0) {
                answer = 0;
                break;
            }
            Melt();
            answer++;
        }

        System.out.println(answer);
    }
    static int SeparateNum() {
        boolean[][] visited = new boolean[N][M];

        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(A[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    static void DFS(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M && A[nx][ny] != 0 && !visited[nx][ny]) {
                DFS(nx, ny, visited);
            }
        }
    }

    static void Melt() {
        Queue<Ice> queue = new LinkedList<>();

        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(A[i][j] != 0) {
                    queue.offer(new Ice(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Ice ice = queue.poll();

            int seaNum = 0;

            for(int i=0; i<4; i++) {
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && A[nx][ny] == 0 && !visited[nx][ny]) {
                    seaNum++;
                }
            }

            if(A[ice.x][ice.y] - seaNum < 0) {
                A[ice.x][ice.y] = 0;
            }
            else {
                A[ice.x][ice.y] -= seaNum;
            }
        }
    }
}

class Ice {
    int x;
    int y;

    public Ice(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


