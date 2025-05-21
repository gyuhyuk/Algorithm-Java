package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7733 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            int maxCheese = 0;

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxCheese = Math.max(maxCheese, map[i][j]);
                }
            }

            int result = 1;

            for(int day=1; day<=maxCheese; day++) {
                visited = new boolean[N][N];

                int count = 0;

                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        if(!visited[i][j] && map[i][j] > day) {
                            DFS(i, j, day);
                            count++;
                        }
                    }
                }

                result = Math.max(result, count);
            }

            System.out.println("#" + t + " " + result);
        }
    }

    static void DFS(int x, int y, int day) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(!visited[nx][ny] && map[nx][ny] > day) {
                    DFS(nx, ny, day);
                }
            }
        }
    }
}
