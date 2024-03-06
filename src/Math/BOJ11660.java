package Math;

import java.util.Scanner;

public class BOJ11660 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int question = scanner.nextInt();

        int[][] matrix1 = new int[size+1][size+1];
        int[][] matrix2 = new int[size+1][size+1];

        for(int i=1; i<=size; i++) {
            for(int j=1; j<=size; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        for(int i=1; i<=size; i++) {
            for(int j=1; j<=size; j++) {
                matrix2[i][j] = matrix2[i][j-1] + matrix2[i-1][j] - matrix2[i-1][j-1] + matrix1[i][j];
            }
        }

        for(int i=0; i<question; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            int result = matrix2[x2][y2] - matrix2[x1-1][y2] - matrix2[x2][y1-1] + matrix2[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
