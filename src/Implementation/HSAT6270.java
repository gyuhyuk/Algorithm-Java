package Implementation;

import java.util.Scanner;

public class HSAT6270 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도로의 구간 개수
        int m = sc.nextInt(); // 실제 주행한 구간 개수

        int[] partSpeed = new int[101]; // 속도 제한 저장 배열
        int disSum = 0; // 현재까지의 거리 합산

        // 제한 속도 입력 처리
        for (int i = 0; i < n; i++) {
            int distance = sc.nextInt();
            int speed = sc.nextInt();

            for (int j = disSum; j < disSum + distance; j++) {
                partSpeed[j + 1] = speed; // 1-based index
            }
            disSum += distance;
        }

        disSum = 0; // 실제 주행 거리 합산 초기화
        int maxExceed = 0; // 최대 초과 속도

        // 실제 주행 속도 입력 처리
        for (int i = 0; i < m; i++) {
            int distance = sc.nextInt();
            int speed = sc.nextInt();

            for (int j = disSum; j < disSum + distance; j++) {
                partSpeed[j + 1] = speed - partSpeed[j + 1]; // 실제 속도 - 제한 속도
                maxExceed = Math.max(maxExceed, partSpeed[j + 1]); // 최대값 갱신
            }
            disSum += distance;
        }

        System.out.println(maxExceed); // 결과 출력
        sc.close();
    }
}
