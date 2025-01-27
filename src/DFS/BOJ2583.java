package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2583 {
    static int N, M, K;
    static int[][] A;
    static boolean[][] visited;
    static ArrayList<Integer> areaArr = new ArrayList<>();
    static int countArea;
    static int[] dx = {-1, 0, 1, 0}; // 4방향 탐색
    static int[] dy = {0, 1, 0, -1}; // 4방향 탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for(int j=b; j<d; j++) {
                for(int k=a; k<c; k++) {
                    A[j][k] = 1;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(A[i][j] == 0 && !visited[i][j]) {
                    int area = DFS(i, j);
                    areaArr.add(area);
                    countArea++;
                }
            }
        }

        System.out.println(countArea);
        Collections.sort(areaArr);
        for(int i=0; i<areaArr.size(); i++) {
            System.out.print(areaArr.get(i) + " ");
        }
    }

    static int DFS(int x, int y) {
        visited[x][y] = true;
        int area = 1;

        for(int i=0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY < 0 || newX >= N || newY >= M) {
                continue;
            }

            if(A[newX][newY] == 1 || visited[newX][newY]) {
                continue;
            }

            area += DFS(newX, newY);
        }

        return area;
    }
}
