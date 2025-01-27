package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {
    static int[][] A;
    static boolean[][] visited;
    static int w, h, answer;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 너비
            h = Integer.parseInt(st.nextToken()); // 높이
            answer = 0;

            if (w == 0 && h == 0) {
                break;
            }

            A = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && A[i][j] == 1) {
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

        for (int i = 0; i < 8; i++) { // 8방향 탐색
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newY < 0 || newX >= h || newY >= w || visited[newX][newY] || A[newX][newY] == 0) {
                continue;
            }

            DFS(newX, newY);
        }
    }package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

    public class BOJ4963 {
        static int[][] A;
        static boolean[][] visited;
        static int w, h, answer;
        static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();

            while (true) {
                st = new StringTokenizer(br.readLine());
                w = Integer.parseInt(st.nextToken()); // 너비
                h = Integer.parseInt(st.nextToken()); // 높이
                answer = 0;

                if (w == 0 && h == 0) {
                    break;
                }

                A = new int[h][w];
                visited = new boolean[h][w];

                for (int i = 0; i < h; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < w; j++) {
                        A[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if (!visited[i][j] && A[i][j] == 1) {
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

            for (int i = 0; i < 8; i++) { // 8방향 탐색
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newY < 0 || newX >= h || newY >= w || visited[newX][newY] || A[newX][newY] == 0) {
                    continue;
                }

                DFS(newX, newY);
            }
        }
    }

}
