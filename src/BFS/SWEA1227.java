package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1227 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            map = new int[100][100];
            visited = new boolean[100][100];

            flag = false;

            int tc = Integer.parseInt(br.readLine());

            for(int i=0; i<100; i++) {
                String s = br.readLine();
                for(int j=0; j<100; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            for(int i=0; i<100; i++) {
                for(int j=0; j<100; j++) {
                    if(map[i][j] == 2) {
                        BFS(i, j);
                    }
                }
            }

            System.out.println("#" + tc + " " + (flag ? "1" : "0"));
        }
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            if (map[cx][cy] == 3) {
                flag = true;
                return;
            }

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && !visited[nx][ny] && map[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
