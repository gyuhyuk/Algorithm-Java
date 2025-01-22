package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16173 {
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int [][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);

        System.out.println("Hing");
    }
    private static void DFS(int start, int end) {
        if(arr[start][end] == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for(int i=0; i<2; i++) {
            int x = start + dx[i] * arr[start][end];
            int y = end + dy[i] * arr[start][end];
            if(x>=N || y>=N || visited[x][y]) {
                continue;
            }

            visited[x][y] = true;
            DFS(x,y);
        }
    }
}
