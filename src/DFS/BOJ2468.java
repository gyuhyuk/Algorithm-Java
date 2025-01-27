package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2468 {
    static int[][] A;
    static boolean[][] visited;
    static int N, count, max;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(A[i][j], max);
            }
        }

        for(int h=1; h<=max; h++) {
            visited = new boolean[N][N];
            count = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(A[i][j] > h && !visited[i][j]) {
                        count++;
                        DFS(i, j, h);
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    static void DFS(int x, int y, int h) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N) && !visited[nx][ny] && A[nx][ny] > h) {
                DFS(nx, ny, h);
            }
        }
    }
}
