package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int N, M; // 세로, 가로
    static int[][] arr; // 2차원 int 배열
    static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dy = {0, 1, 0, -1}; // 상 우 하 좌
    static int maxSafeZone = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        arr = new int[N][M]; // 배열 초기화

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);

        System.out.println(maxSafeZone);
    }

    private static void DFS(int wall) { // 벽을 3개 설치했을 때 BFS 실행
        if(wall == 3) {
            BFS();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    DFS(wall+1);
                    arr[i][j] = 0; // 백트래킹
                }
            }
        }
    }

    private static void BFS() {
        Queue<Virus> queue = new LinkedList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 2) {
                    queue.add(new Virus(i, j));
                }
            }
        }

        int[][] copyArr = new int[N][M];

        for(int i=0; i<N; i++) {
            copyArr[i] = arr[i].clone();
        }

        while (!queue.isEmpty()) {
            Virus now = queue.poll();
            int x = now.x;
            int y = now.y;

            for(int i=0; i<4; i++) { // 상하좌우 탐색
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(0 <= newX && newX < N && 0 <= newY && newY < M) { // 크기 내부에서만 바이러스 감염
                    if(copyArr[newX][newY] == 0) { // 감염이 안되어있으면
                        queue.add(new Virus(newX, newY)); // 큐에 넣고
                        copyArr[newX][newY] = 2; // 감염으로 변경
                    }
                }
            }
        }

        calculateSafeZone(copyArr);
    }

    private static void calculateSafeZone(int[][] copyArr) {
        int safeZone = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copyArr[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        if(maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
        }
    }

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
