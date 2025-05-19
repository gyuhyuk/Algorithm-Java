package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1226 {
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            map = new int[16][16];
            visited = new boolean[16][16];

            flag = false;
            int user = Integer.parseInt(br.readLine());

            for(int i=0; i<16; i++) {
                String s = br.readLine();
                for(int j=0; j<16; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            outer:
            for(int i=0; i<16; i++) {
                for(int j=0; j<16; j++) {
                    if(map[i][j] == 2) {
                        DFS(i, j);
                        System.out.println("#" + user + " " + (flag ? "1" : "0"));
                        break outer;
                    }
                }
            }
        }
    }

    static void DFS(int x, int y) {
        visited[x][y] = true;

        if(map[x][y] == 3) {
            flag = true;
            return;
        }


        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < 16 && ny >= 0 && ny < 16 && !visited[nx][ny] && map[nx][ny] != 1) {
                if(flag) return;
                DFS(nx, ny);
            }
        }
    }
}
