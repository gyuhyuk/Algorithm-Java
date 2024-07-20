package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ1920 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 데이터 개수 입력

        ArrayList<Integer> arr = new ArrayList<>(); // 데이터를 넣을 arr 선언

        for(int i=0; i<N; i++) { // N번 반복하여 arr에 삽입
            arr.add(scanner.nextInt());
        }

        Collections.sort(arr); // 오름차순으로 정렬

        int M = scanner.nextInt(); // 찾아야 할 숫자 개수

        for(int i=0; i<M; i++) { // 찾아야 할 숫자 개수만큼 반복
            boolean find = false; // find 변수 false로 선언
            int target = scanner.nextInt(); // traget 입력받음
            int start = 0; // start index는 0부터
            int end = arr.size()-1; // end는 마지막 인덱스
            while (start <= end) {
                int midIndex =  (start + end) / 2; // start와 end의 중간 값이 mid 인덱스
                int midValue = arr.get(midIndex); // mid 인덱스에 해당하는 value

                if(midValue > target) { // value가 target보다 크면,
                    end = midIndex - 1; // end 값을 mid 인덱스보다 1 작게 설정
                } else if (midValue < target) { // value가 target보다 작으면,
                    start = midIndex + 1; // start 값을 mid 인덱스보다 1 크게 설정
                }
                else { // 찾으면
                    find = true; // true로 설정하면서
                    break; // 빠져나오기
                }
            }
            if (find) { // 찾았다면
                System.out.println(1); // 1 출력
            }
            else { // 못찾았다면
                System.out.println(0); // 0 출력
            }
        }
    }
}
