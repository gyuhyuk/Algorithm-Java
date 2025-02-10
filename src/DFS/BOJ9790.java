package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9790 {
    static char [][] A;
    static boolean [][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) {
                break;
            }

            A = new char[N][M];
            visited = new boolean[N][M];

            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<M; j++) {
                    A[i][j] = s.charAt(j);
                }
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(A[i][j] == 'A' && !visited[i][j]) {
                        int area = dfs(i, j);
                        sb.append(area).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1; // 현재 칸 포함

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크 + 방문 여부 체크 + 벽('#')이면 지나가지 않도록
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]
                    && A[nx][ny] == '.' && A[nx][ny] != '#') {
                area += dfs(nx, ny);
            }
        }
        return area;
    }
}
