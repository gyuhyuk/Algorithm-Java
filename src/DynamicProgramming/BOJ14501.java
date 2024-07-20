package DynamicProgramming;
import java.util.Scanner;

public class BOJ14501 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] D = new int[N+2];
        int[] T = new int[N+1];
        int[] P = new int[N+1];

        for(int i=1; i<=N; i++) {
            T[i] = scanner.nextInt();
            P[i] = scanner.nextInt();
        }

        for(int i=N; i>0; i--) {
            if(i+T[i] > N+1) { // 일을 못하는 경우
                D[i] = D[i+1];
            }
            else {
                D[i] = Math.max(D[i+1], D[i+T[i]] + P[i]);
            }
        }

        System.out.println(D[1]);
    }
}
