package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SWEA1210 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0}; // 좌, 상, 우
    static int[] dy = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t=1; t<=10; t++) {
            int user = Integer.parseInt(br.readLine());
            map = new int[100][100];
            visited = new boolean[100][100];

            for(int i=0; i<100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int x = 99;
            int y = 0;

            for(int i=0; i<100; i++) {
                if(map[99][i] == 2) {
                    y = i;
                    break;
                }
            }

            while (x > 0) {
                visited[x][y] = true;

                if(y > 0 && map[x][y-1] == 1 && !visited[x][y-1]) { // 좌측
                    while (y > 0 && map[x][y - 1] == 1 && !visited[x][y - 1]) {
                        y--;
                        visited[x][y] = true;
                    }
                }

                else if (y < 99 && map[x][y + 1] == 1 && !visited[x][y + 1]) { // 우측
                    while (y < 99 && map[x][y + 1] == 1 && !visited[x][y + 1]) {
                        y++;
                        visited[x][y] = true;
                    }
                }

                x--;

            }
            System.out.println("#" + user + " " + y);;
        }
    }
}
