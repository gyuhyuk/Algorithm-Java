package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {
    static boolean[][] visited;
    static int[][] chess;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int size;
    static int startX, startY, finishX, finishY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(st.nextToken());
        for(int i=1; i<=testcase; i++) { // 3번
            st = new StringTokenizer(br.readLine()); // 8
            size = Integer.parseInt(st.nextToken()); // 사이즈는 8 x 8
            chess = new int[size][size]; // 체스판 크기
            visited = new boolean[size][size]; // 방문판
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken()); // 0
            startY = Integer.parseInt(st.nextToken()); // 0
            st = new StringTokenizer(br.readLine());
            finishX = Integer.parseInt(st.nextToken()); // 7
            finishY = Integer.parseInt(st.nextToken()); // 0
            BFS();

            sb.append(chess[finishX][finishY]).append("\n");
        }
        System.out.println(sb);
    }

    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            for(int i=0; i<8; i++) {
                int ox = nx + dx[i];
                int oy = ny + dy[i];

                if(ox >= 0 && oy >= 0 && ox < size && oy < size && !visited[ox][oy]) {
                    queue.add(new int[]{ox, oy});
                    chess[ox][oy] = chess[nx][ny] + 1;
                    visited[ox][oy] = true;
                }
            }
        }
    }
}
