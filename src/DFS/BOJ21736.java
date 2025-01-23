package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21736 {
    static int N, M, startX, startY, count;
    static char[][] arr;
    static boolean[][] visited;
    static char wall = 'X';
    static char person = 'P';
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
           String S = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = S.charAt(j);
                if(arr[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        DFS(startX, startY);

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if(nowX < 0 || nowY < 0 || nowX >= N || nowY >= M || arr[nowX][nowY] == wall) {
                continue;
            }

            if(!visited[nowX][nowY]) {
                if(arr[nowX][nowY] == person) {
                    count++;
                }
                DFS(nowX, nowY);
            }
        }
    }
}
