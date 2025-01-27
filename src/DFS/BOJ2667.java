package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2667 {
    static int[][] A;
    static boolean[][] visited;
    static int N;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0}; // 4방향 탐색
    static int[] dy = {0, 1, 0, -1}; // 4방향 탐색
    static int totalArea = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<N; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(A[i][j] == 1 && !visited[i][j]) {
                    int area = DFS(i, j);
                    arr.add(area);
                    totalArea++;
                }
            }
        }

        Collections.sort(arr);
        System.out.println(totalArea);
        for(int i=0; i<arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    static int DFS(int x, int y) {
        int area = 1;
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY < 0 || newX >= N || newY >= N) {
                continue;
            }
            if(A[newX][newY] == 0 || visited[newX][newY]) {
                continue;
            }

            if(A[newX][newY] == 1 && !visited[newX][newY]) {
                area += DFS(newX, newY);
            }
        }

        return area;
    }
}
