package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int answer = 1;
            int[][] map = new int[9][9];
            for(int i=0; i<9; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<9; i++) { // 가로 합
                int valid = 0;
                for(int j=0; j<9; j++) {
                    valid += map[i][j];
                }
                if(valid != 45) {
                    answer = 0;
                    break;
                }
            }

            for(int i=0; i<9; i++) { // 세로 합
                int valid = 0;
                for(int j=0; j<9; j++) {
                    valid += map[j][i];
                }
                if(valid != 45) { // 45가 아니면 return 해서 answer = 0;
                    answer = 0;
                    break;
                }
            }

            for(int k=0; k<9; k++) {
                int box = 0;

                int startRow = (k/3) * 3;
                int startCol = (k%3) * 3;

                for(int i=0; i<3; i++) {
                    for(int j=0; j<3; j++) {
                        box += map[startRow+i][startCol+j];
                    }
                }

                if(box != 45) {
                    answer = 0;
                    break;
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}
