package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA2819 {
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder path = new StringBuilder();
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            map = new int[4][4];
            set.clear();

            for(int i=0; i<4; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    path.setLength(0);
                    DFS(i, j);
                }
            }

            System.out.println("#" + t + " " + set.size());
        }
    }

    static void DFS(int x, int y) {
        if(path.length() == 7) {
            set.add(path.toString());
            return;
        }

        path.append(map[x][y]);

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
                DFS(nx, ny);
            }
        }

        path.setLength(path.length() - 1);
    }
}