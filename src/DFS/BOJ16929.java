package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16929 {
    static int N, M;
    static char[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int startX;
    static int startY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                A[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visited = new boolean[N][M];
                startX = i;
                startY = j;
                if(dfs(i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    static boolean dfs(int x, int y, int count) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M && A[x][y] == A[nx][ny]) {
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(dfs(nx, ny, count+1)) return true;
                }
                else {
                    if(count >= 4 && startX == nx && startY == ny) return true;
                }
            }
        }

        return false;
    }
}
