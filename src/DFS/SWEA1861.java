package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1861 {
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxCount;
    static int startNum;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            maxCount = 0;
            startNum = Integer.MAX_VALUE;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    int count = DFS(i, j);

                    if(count > maxCount) {
                        maxCount = count;
                        startNum = map[i][j];
                    } else if(count == maxCount && map[i][j] < startNum) {
                        startNum = map[i][j];
                    }
                }
            }

            System.out.println("#" + t + " " + startNum + " " + maxCount);
        }
    }

    static int DFS(int x, int y) {
        int max = 1;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(map[nx][ny] == map[x][y] + 1) {
                    max = Math.max(max, 1 + DFS(nx, ny));
                }
            }
        }

        return max;
    }
}
