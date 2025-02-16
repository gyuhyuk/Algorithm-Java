package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13565 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean escaped = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i=0; i<M; i++) {
            if(map[0][i] == 0 && !visited[0][i]) {
                dfs(0, i);
                if(escaped) {
                    break;
                }
            }
        }

        if(!escaped) {
            System.out.println("NO");
        }
    }

    static void dfs(int x, int y) {
        if(escaped) {
            return;
        }
        visited[x][y] = true;

        if(x == N - 1) {
            System.out.println("YES");
            escaped = true;
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }
    }
}
