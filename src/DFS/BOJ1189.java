package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1189 {
    static char[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;
    static int R, C, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new char[R+1][C+1];
        visited = new boolean[R+1][C+1];

        for(int i=1; i<=R; i++) {
            String input = br.readLine();
            for(int j=1; j<=C; j++) {
                char c = input.charAt(j-1);
                A[i][j] = c;

                if(c == 'T') {
                    visited[i][j] = true;
                }
            }
        }

        visited[R][1] = true;
        DFS(R, 1, 1);
        System.out.println(answer);
    }

    static void DFS(int r, int c, int depth) {
        if(r == 1 && c == C) {
            if(depth == K) {
                answer++;
            }
            return;
        }

        for(int i=0; i<4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(1<= nr && nr <=R && 1<=nc && nc <= C) {
                if(visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                A[nr][nc] = '-';
                DFS(nr, nc, depth+1);
                visited[nr][nc] = false;
                A[nr][nc] = '.';
            }
        }
    }
}
