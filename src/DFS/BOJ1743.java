package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1743 {
    static int N, M, K;
    static int[][] A;
    static boolean[][] visited;
    static int MAX = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x][y] = 1;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(A[i][j] == 1 && !visited[i][j]) {
                   int area = dfs(i, j);
                   MAX = Math.max(area, MAX);
                }
            }
        }

        System.out.println(MAX);
    }
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && ny >= 1 && nx <= N && ny <=M && !visited[nx][ny] && A[nx][ny] == 1) {
                area += dfs(nx, ny);
            }
        }
        return area;
    }
}
