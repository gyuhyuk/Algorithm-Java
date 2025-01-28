package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1987 {
    static char[][] A;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int R, C;
    static int max = 0;
    static boolean[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로

        A = new char[R][C];
        alpha = new boolean[26];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for(int j=0; j<C; j++) {
                A[i][j] = s.charAt(j);
            }
        }

        DFS(0, 0, 1);

        System.out.println(max);
    }

    static void DFS(int x, int y, int depth) {
        alpha[A[x][y] - 'A'] = true;
        max = Math.max(max, depth);

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >=0 && nx < R && ny < C && !alpha[A[nx][ny] - 'A']) {
                DFS(nx, ny, depth + 1);
            }
        }
        alpha[A[x][y] - 'A'] = false;
    }
}
