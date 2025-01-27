package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 4방향 탐색
    static int[] dy = {0, 1, 0, -1}; // 4방향 탐색
    static int T, M, N, K, answer;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken()); // 테스트케이스 개수

        for(int t=0; t<T; t++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            A = new int[M][N];
            visited = new boolean[M][N];

            for(int i=0; i<K; i++) { // 배추 개수
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                A[x][y] = 1;
            }

            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(A[i][j] == 1 && !visited[i][j]) {
                        DFS(i, j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY < 0 || newX >= M || newY >= N || visited[newX][newY] || A[newX][newY] == 0) {
                continue;
            }

            if(!visited[newX][newY] && A[newX][newY] == 1) {
                DFS(newX, newY);
            }
        }
    }
}
