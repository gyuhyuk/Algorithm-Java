package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        int row = 0;
        int col = 0;

        for(int i=0; i<N; i++) {
            int count = 0;
            for(int j=0; j<N; j++) {
                if (map[i][j] == '.') {
                    count++;
                } else {
                    if(count >= 2) {
                        row++;
                    }
                    count = 0;
                }
            }
            if(count >= 2) {
                row++;
            }
        }

        for(int i=0; i<N; i++) {
            int count = 0;
            for(int j=0; j<N; j++) {
                if (map[j][i] == '.') {
                    count++;
                } else {
                    if(count >= 2) {
                        col++;
                    }
                    count = 0;
                }
            }
            if(count >= 2) {
                col++;
            }
        }

        System.out.println(row + " " + col);
    }
}
