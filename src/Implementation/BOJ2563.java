package Implementation;

import java.util.Scanner;

public class BOJ2563 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] D = new int[101][101];
        int n = scanner.nextInt();
        int sum = 0;

        for(int i=0; i<n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for(int j=x; j<x+10; j++) {
                for(int k=y; k<y+10; k++) {
                    D[j][k] = 1;
                }
            }
        }

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++) {
                if(D[i][j] == 1) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }
}
