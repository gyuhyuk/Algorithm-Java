package TwoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1940 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            list.add(scanner.nextInt());
        }

        Collections.sort(list);

        int start = 0;
        int end = N-1;
        int count = 0;

        while(start < end) {
            if(list.get(start) + list.get(end) < M) {
                start++;
            }
            else if (list.get(start) + list.get(end) > M) {
                end--;
            }
            else {
                count++;
                start++;
                end--;
            }
        }
        System.out.println(count);
    }
}
