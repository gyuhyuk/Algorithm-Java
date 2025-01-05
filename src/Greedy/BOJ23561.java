package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ23561 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 3 * N; i++) {
            arr.add(scanner.nextInt());
        }

        // 정렬
        Collections.sort(arr);

        // 양 끝 N개의 값을 제외한 중간 부분만 사용
        int minIndex = N; // N번째 요소
        int maxIndex = 3 * N - N - 1; // 3*N - N번째 요소

        System.out.println(arr.get(maxIndex) - arr.get(minIndex));
    }
}
