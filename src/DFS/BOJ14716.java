package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14716 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    // 0,0 0,1 0,2
    // 1,0 1,1 1,2
    // 2,0 2,1 2,2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    DFS(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void DFS(int a, int b) {
        visited[a][b] = true;
        for(int i=0; i<8; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if(x < 0 || x >= N || y<0 || y >= M || map[x][y] != 1 || visited[x][y]) {
                continue;
            }
            DFS(x, y);
        }
    }
}
