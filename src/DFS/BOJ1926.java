package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1926 {
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0}; // 4방향 탐색
    static int[] dy = {0, 1, 0, -1}; // 4방향 탐색
    static int N, M;
    static int maxArea = 0; // 최대 크기
    static int numPicture = 0; // 그림 개수
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    int area = DFS(i, j);
                    maxArea = Math.max(area, maxArea);
                    numPicture++;
                }
            }
        }

        System.out.println(numPicture);
        System.out.println(maxArea);
    }

    static int DFS(int x, int y) {
        int area = 1;
        visited[x][y] = true;

        for(int i=0; i<4; i++) { // 4방향 탐색
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY < 0 || newX >= N || newY >= M) { // 배열의 크기를 벗어나면 continue
                continue;
            }
            if(visited[newX][newY] || arr[newX][newY] == 0) { // 방문했거나 0이면 무시
                continue;
            }
            area += DFS(newX, newY); // area 계속 더해가기
        }
        return area;
    }
}
