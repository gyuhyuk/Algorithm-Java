package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1303 {
    static int myTeam, enemy, N, M;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 'W' && !visited[i][j]) {
                    int area = myTeamDFS(i, j);
                    myTeam += area*area;
                }
                if(map[i][j] == 'B' && !visited[i][j]) {
                    int area = enemyDFS(i, j);
                    enemy += area*area;
                }
            }
        }

        System.out.println(myTeam + " " + enemy);
    }

    static int myTeamDFS(int x, int y) {
        int area = 1;
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && map[nx][ny] == 'W') {
                area += myTeamDFS(nx, ny);
            }
        }
        return area;
    }
    static int enemyDFS(int x, int y) {
        int area = 1;
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && map[nx][ny] == 'B') {
                area += enemyDFS(nx, ny);
            }
        }
        return area;
    }
}
