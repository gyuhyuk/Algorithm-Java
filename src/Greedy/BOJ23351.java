package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ23351 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int[] arr = new int[N];
        int cnt = 0;

        Arrays.fill(arr, K); // 초기 배열 K로 채우기

        while (true) {
            // 가장 적합한 연속 A개의 화분에 물 주기
            int startIndex = findBestIndex(arr, A);
            for (int i = startIndex; i < startIndex + A; i++) {
                arr[i] += B;
            }

            // 하루가 지나면 모든 화분의 수분이 1씩 감소
            Arrays.setAll(arr, i -> arr[i] - 1);
            cnt++;

            // 배열에 죽은 화분(0 이하)이 있는지 확인
            if (contains(arr, 0)) {
                break;
            }
        }

        System.out.println(cnt);
    }

    // 가장 적합한 연속 A개의 화분 시작 인덱스를 찾는 함수
    public static int findBestIndex(int[] arr, int A) {
        int minSum = Integer.MAX_VALUE;
        int bestIndex = 0;

        // 모든 연속된 A개의 구간을 검사
        for (int i = 0; i <= arr.length - A; i++) {
            int sum = 0;
            for (int j = i; j < i + A; j++) {
                sum += arr[j];
            }
            if (sum < minSum) {
                minSum = sum;
                bestIndex = i;
            }
        }

        return bestIndex;
    }

    // 배열에 특정 값(value)이 포함되어 있는지 확인하는 함수
    public static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num <= value) { // 화분이 죽는 조건 (0 이하)
                return true;
            }
        }
        return false;
    }
}
