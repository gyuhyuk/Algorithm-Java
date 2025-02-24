package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ26170 {
    static int[][] arr = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int r, c;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited[r][c] = true;

        dfs(r, c, 0, 0);

        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer);
        }

    }
    static void dfs(int x, int y, int apple, int d) {
        if(apple == 3) {
            answer = Math.min(answer, d);
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && arr[nx][ny] != -1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                if(arr[nx][ny] == 1) {
                    dfs(nx, ny, apple+1, d+1);
                }
                else {
                    dfs(nx, ny, apple, d+1);
                }
                visited[nx][ny] = false;
            }
        }
    }
}
