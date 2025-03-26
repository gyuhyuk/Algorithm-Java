package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp2605 {
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int totalCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        A = new int[7][7];
        visited = new boolean[7][7];

        for(int i=0; i<7; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<7; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                if(!visited[i][j]) {
                    int area = DFS(i, j);
                    if(area >= 3) {
                        totalCount++;
                    }
                }
            }
        }

        System.out.println(totalCount);
    }

    static int DFS(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < 7 && ny < 7 && !visited[nx][ny] && A[x][y] == A[nx][ny]) {
                count += DFS(nx, ny);
            }
        }
        return count;
    }
}
