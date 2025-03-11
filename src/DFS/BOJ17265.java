package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17265 {
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int N;
    static char[][] A;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new char[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                A[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0, 0, Integer.parseInt(String.valueOf(A[0][0])), A[0][0], A);

        System.out.println(max + " " + min);
    }

    static void dfs(int x, int y, int ans, char oper, char[][] A) {
        for(int i=0; i<2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <= N-1 && ny <= N-1) {
                if(A[nx][ny] == '+') {
                    dfs(nx, ny, ans, '+', A);
                } else if(A[nx][ny] == '-') {
                    dfs(nx, ny, ans, '-', A);
                } else if(A[nx][ny] == '*') {
                    dfs(nx, ny, ans, '*', A);
                } else {
                    int result = 0;

                    if(oper == '+') {
                        result = ans + Integer.parseInt(String.valueOf(A[nx][ny]));
                    } else if(oper == '-') {
                        result = ans - Integer.parseInt(String.valueOf(A[nx][ny]));
                    } else if(oper == '*') {
                        result = ans * Integer.parseInt(String.valueOf(A[nx][ny]));
                    }

                    if(nx == N-1 && ny == N-1) {
                        max = Math.max(max, result);
                        min = Math.min(min, result);

                        return;
                    }

                    dfs(nx, ny, result, A[nx][ny], A);
                }

            }
        }
    }
}
