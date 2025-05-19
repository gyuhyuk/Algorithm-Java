package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int count = 0;
            int user = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];

            for(int i=0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int col = 0; col < 100; col++) {
                boolean foundN = false;

                for (int row = 0; row < 100; row++) {
                    if (map[row][col] == 1) {
                        foundN = true;
                    } else if (map[row][col] == 2 && foundN) {
                        count++;
                        foundN = false;
                    }
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}