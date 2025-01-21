package Math;

import java.util.Scanner;

public class BOJ32194 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N + 2];
        int[] prefixSum = new int[N + 2]; // 구간 합 배열

        arr[0] = 0;
        arr[1] = 1;
        prefixSum[1] = arr[1]; // 초기 구간 합 설정

        for (int i = 2; i <= N + 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // 구간 합 계산
            int sum = prefixSum[c] - prefixSum[b - 1];

            if (a == 1) { // 대답이 모두 "Yes"일 때
                if (sum == c - b + 1) { // 구간 합이 구간의 크기와 동일
                    arr[i] = 1;
                }
            } else if (a == 2) { // 대답이 모두 "No"일 때
                if (sum == 0) { // 구간 합이 0
                    arr[i] = 1;
                }
            } else {
                arr[i] = 0; // 기본 값은 0
            }

            // 현재 값 추가하여 구간 합 갱신
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // 결과 출력
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
