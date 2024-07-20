package BinarySearch;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2343 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        int start = 0;
        int end = 0;

        for(int i=0; i<N; i++) {
            arr.add(scanner.nextInt());
            if(start < arr.get(i)) { // 레슨 최대 값을 시작 인덱스로 저장
                start = arr.get(i);
            }
            end = end + arr.get(i); // 모든 레슨의 총합을 종료 인덱스로 저장
        }

        while(start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for(int i=0; i<N; i++) { // mid 값으로 모든 레슨을 저장할 수 있는지 확인
                if(sum + arr.get(i) > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr.get(i);
            }

            if(sum != 0) { // 탐색 후 sum이 0이 아니면 블루레이가 1개 더 필요하므로 더함
                count++;
            }
            if (count > M) {
                start = mid + 1;
            }
            else {
                end = mid -1;
            }
        }
            System.out.println(start);
    }
}
