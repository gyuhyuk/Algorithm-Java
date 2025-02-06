package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HSAT6246 {
    static int n, m, total;
    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int startX, startY, endX, endY;
    static boolean[][] visited;
    static ArrayList<Integer> list;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        total = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        list = new ArrayList<>();

        for(int i=1; i<=n; i++) { // 격자 만들기
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        for(int i=0; i<m-2; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x][y] = 2;
        }

        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

//        for(int i=1; i<=n; i++) {
//            for(int j=1; j<=n; j++) {
//                if(A[i][j] == 2) {
//                    total++;
//                }
//            }
//        }

        dfs(startX, startY);
        System.out.println(count);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        list.add(A[x][y]);  // 현재 위치를 먼저 추가

        if(x == endX && y == endY) {
            if(isCorrect(list)) {
                count++;
            }
            visited[x][y] = false;
            list.remove(list.size() - 1);
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && ny >= 1 && nx <= n && ny <= n && !visited[nx][ny] && A[nx][ny] != 1) {
                dfs(nx, ny);
            }
        }

        visited[x][y] = false;
        list.remove(list.size() - 1);
    }

    static boolean isCorrect(ArrayList<Integer> list) {
        int sum = 0;
        for(int i=0; i<list.size(); i++) {
            if (list.get(i) == 2) {
                sum += 1;
            }
        }

        if(sum == m-2) {
            return true;
        }
        return false;
    }
}
