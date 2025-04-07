package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ26169 {
    static int r,c;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static boolean possible = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited[r][c] = true;
        DFS(r,c, 0, 0);
        System.out.println(possible ? 1 : 0);
    }
    static void DFS(int x, int y, int depth, int apple) {
        if (depth > 3 || possible) return;

        if(apple >= 2) {
            possible = true;
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && !visited[nx][ny] && map[nx][ny] != -1) {
                visited[nx][ny] = true;
                int nextApple = apple + (map[nx][ny] == 1 ? 1 : 0);
                DFS(nx, ny, depth+1, nextApple);
                visited[nx][ny] = false;
            }
        }
    }
}