package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int[][] map = new int[100][100];
            ArrayList<Integer> arr = new ArrayList<>();

            // 입력 받기
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int rightDiagonal = 0;
            int leftDiagonal = 0;

            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                    rowSum += map[i][j];   // 가로 합
                    colSum += map[j][i];   // 세로 합
                }
                arr.add(rowSum);
                arr.add(colSum);

                // 대각선은 한 번만 계산
                rightDiagonal += map[i][i];
                leftDiagonal += map[i][99 - i];
            }

            arr.add(rightDiagonal);
            arr.add(leftDiagonal);

            // 최대값 구하기
            int max = Collections.max(arr);
            System.out.println("#" + t + " " + max);
        }
    }
}
