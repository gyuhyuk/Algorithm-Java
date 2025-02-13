package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3184 {
    static int R, C, sheep, fox, areaSheep, areaFox;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'v') {
                    fox++;
                }
                else if (arr[i][j] == 'o') {
                    sheep++;
                }
            }
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j] != '#' && !visited[i][j]) {
                    areaFox = 0;
                    areaSheep = 0;
                    dfs(i, j);
                    if(areaSheep > areaFox) {
                        fox -= areaFox;
                    }
                    else {
                        sheep -= areaSheep;
                    }
                }
            }
        }
        System.out.println(sheep + " " + fox);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        if(arr[x][y] == 'o') {
            areaSheep++;
        }
        else if(arr[x][y] == 'v') {
            areaFox++;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny] && arr[nx][ny] != '#') {
                dfs(nx, ny);
            }
        }
    }
}
