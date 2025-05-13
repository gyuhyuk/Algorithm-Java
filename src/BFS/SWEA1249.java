package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1249 {
    static int N;
    static int[][] map, minTime;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            minTime = new int[N][N];

            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                    minTime[i][j] = Integer.MAX_VALUE;
                }
            }

            BFS(0, 0);

            System.out.println("#" + t + " " + minTime[N-1][N-1]);
        }
    }

    static void BFS(int startY, int startX) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startY, startX));
        minTime[startY][startX] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int currentY = now.y;
            int currentX = now.x;

            for(int i=0; i<4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    int newCost = minTime[currentY][currentX] + map[ny][nx];

                    if(newCost < minTime[ny][nx]) {
                        minTime[ny][nx] = newCost;
                        queue.offer(new Node(ny, nx));
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
