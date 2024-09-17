package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ9252 {
    private static long[][] DP;
    private static ArrayList<Character> Path;
    private static char[] A;
    private static char[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine().toCharArray(); // 입력 받은 것을 char로 변환
        B = br.readLine().toCharArray(); // 입력 받은 것을 char로 변환

        DP = new long[A.length+1][B.length+1]; // DP 테이블 생성

        Path = new ArrayList<Character>(); // Path 초기화

        for(int i=1; i<=A.length; i++) {
            for(int j=1; j<=B.length; j++) {
                if(A[i-1] == B[j-1]) { // A와 B의 문자열이 같으면
                    DP[i][j] = DP[i-1][j-1] + 1; // DP 테®이블의 값을 왼쪽 대각선 위의 값 + 1 로 저장
                } else { // 같지 않다면
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]); // DP 테이블의 왼쪽값과 위의 값 중에 큰 수로 저장
                }
            }
        }

        System.out.println(DP[A.length][B.length]);
        getText(A.length, B.length);
        for(int i= Path.size()-1; i>=0; i--) {
            System.out.print(Path.get(i));
        }
    }

    private static void getText(int r, int c) {
        if (r == 0 || c == 0) return;
        if(A[r-1] == B[c-1]) {
            Path.add(A[r-1]); // 같으면 LCS에 기록하고 왼쪽 위로 이동
            getText(r-1, c-1);
        }
        else {
            if(DP[r-1][c] > DP[r][c-1]) { // 다르면 왼쪽과 위 중에 큰 수로 이동
                getText(r-1, c);
            }
            else {
                getText(r, c-1);
            }
        }
    }
}
