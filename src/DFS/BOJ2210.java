package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ2210 {
    static String[][] map = new String[5][5];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static HashSet<String> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                DFS(i, j, map[i][j], 0);
            }
        }

        System.out.println(answer.size());
    }

    private static void DFS(int x, int y, String route, int count) {
        if(count == 5) {
            answer.add(route);
            return;
        }
        for(int i=0; i<4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if(0 <= nowX && nowX < 5 && 0 <= nowY && nowY < 5) {
                DFS(nowX, nowY, route + map[nowX][nowY], count+1);
            }
        }
    }
}
