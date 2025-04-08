package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ31575 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 5
        M = Integer.parseInt(st.nextToken()); // 4
        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);

        if(flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static void DFS(int x, int y) {
        if(flag) return;

        if(x == M-1 && y == N-1) {
            flag = true;
            return;
        }

        for(int i=0; i<2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }
}
