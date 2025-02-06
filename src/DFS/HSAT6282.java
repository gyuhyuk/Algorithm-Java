package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class HSAT6282 {
    static int N;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> arr = new ArrayList<>();
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

        int answer = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(A[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(i,j);
                    arr.add(area);
                    answer++;
                }
            }
        }

        System.out.println(answer);

        Collections.sort(arr);
        for(int i=0; i<arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    static int dfs(int x, int y) {
        int area = 1;
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && A[nx][ny] != 0) {
                area += dfs(nx, ny);
            }
        }
        return area;
    }
}
