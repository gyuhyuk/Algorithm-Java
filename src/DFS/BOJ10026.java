package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {
    static int N;
    static String S;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i=0; i<N; i++) {
            S = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = S.charAt(j);
            }
        }

        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    DFS(i, j);
                    count++;
                }
            }
        }

        int normalCount = count;

        count = 0;
        visited = new boolean[N+1][N+1];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    DFS(i, j);
                    count++;
                }
            }
        }

        int blindCount = count;
        System.out.println(normalCount + " " + blindCount);
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;
        char temp = arr[x][y];

        for(int i=0; i<4; i++) { // 4개 방향
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY < 0 || newX > N || newY > N) {
                continue;
            }

            if(!visited[newX][newY] && arr[newX][newY] == temp) {
                DFS(newX, newY);
            }
        }
    }
}
