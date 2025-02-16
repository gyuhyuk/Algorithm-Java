package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3187 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int totalWolf = 0, totalSheep = 0; // 전체 늑대, 양 개수
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        // 모든 칸을 탐색하며 새로운 울타리를 찾음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((map[i][j] == 'v' || map[i][j] == 'k') && !visited[i][j]) {
                    int[] count = dfs(i, j);
                    int sheep = count[0];
                    int wolf = count[1];

                    // 한 울타리에서 양이 늑대보다 많으면 늑대가 잡아먹힘
                    if (sheep > wolf) {
                        totalSheep += sheep;
                    } else {
                        totalWolf += wolf;
                    }
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    static int[] dfs(int x, int y) {
        visited[x][y] = true;
        int sheep = 0, wolf = 0;

        // 현재 위치의 양, 늑대 개수 반영
        if (map[x][y] == 'k') sheep++;
        if (map[x][y] == 'v') wolf++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] != '#') {
                int[] result = dfs(nx, ny);
                sheep += result[0];
                wolf += result[1];
            }
        }

        return new int[]{sheep, wolf};
    }
}
