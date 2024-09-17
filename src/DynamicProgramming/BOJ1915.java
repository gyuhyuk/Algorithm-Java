package DynamicProgramming;

import java.util.Scanner;

public class BOJ1915 {
    public static void main(String[] args) {
        long[][] DP = new long[1001][1001]; // 1000 x 1000이 최대 입력 값
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // n
        int m = scanner.nextInt(); // m
        long max = 0; // max 값 0으로 초기화

        for(int i=0; i<n; i++) { // n번 반복
            String mline = scanner.next(); // 숫자를 String으로 한 줄 입력받음
            for(int j=0; j<m; j++) { // m번 반복
                DP[i][j] = Long.parseLong(String.valueOf(mline.charAt(j))); // 입력받은 String 값을 하나씩 char로 까면서 Long으로 파싱해서 하나씩 대입
                if(DP[i][j] == 1 && i > 0 && j > 0) { // DP테이블의 값이 1이면서, j와 i가 0보다 크다면
                    DP[i][j] = Math.min(DP[i-1][j-1], Math.min(DP[i-1][j], DP[i][j-1])) + DP[i][j]; // 왼쪽, 왼쪽 대각선 위, 위 값 중 최소 값에 +1 한 값을 저장
                }
                if(max < DP[i][j]) { // DP테이블 값보다 max값이 작다면,
                    max = DP[i][j]; // max 값을 DP[i][j]값으로 업데이트
                }
            }
        }
        System.out.println(max*max); // 정사각형의 오른쪽 아래 값을 max로 저장했으므로, 그 값의 제곱을 출력하면 답이 된다.
    }
}
