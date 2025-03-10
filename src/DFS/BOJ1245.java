package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1245 {
    static int N, M;
    static boolean[][] visited;
    static int count = 0;
    static boolean isPeak;
    static int[][] A;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j] && A[i][j] > 0) {
                    isPeak = true; // 시작 값을 봉우리라고 생각
                    dfs(i, j); // dfs 실행
                    if(isPeak) count++; // 탐색 끝나고 true면 count 증가
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M) { // 유효한 좌표인지 확인
                if(A[nx][ny] > A[x][y]) { // 새로운 값이 원래 값보다 크면
                    isPeak = false; // peak 값 false
                }

                if(!visited[nx][ny] && A[nx][ny] == A[x][y]) { // 방문하지 않았고, 값이 같으면 재귀함수 실행
                    dfs(nx, ny);
                }
            }
        }
    }
}