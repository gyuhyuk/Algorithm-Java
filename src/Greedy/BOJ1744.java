package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1744 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();

        PriorityQueue<Integer> plusArr = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusArr = new PriorityQueue<>();

        int answer = 0;
        int one = 0;
        int zero  = 0;

        for(int i=0; i<user; i++) {
            int n = scanner.nextInt();

            if(n < 0) {
                minusArr.add(n);
            }
            else if (n == 0) {
                zero++;
            }
            else if (n == 1) {
                one++;
            }
            else {
                plusArr.add(n);
            }
        }

        int sum = 0;

        while (plusArr.size() > 1) {
            int first = plusArr.remove();
            int second = plusArr.remove();
            sum += first*second;
        }
        if(!plusArr.isEmpty()) {
            sum = sum + plusArr.remove();
        }

        while (minusArr.size() > 1) {
            int first = minusArr.remove();
            int second = minusArr.remove();
            sum += first*second;
        }
        if(!minusArr.isEmpty()) {
            if (zero == 0) {
                sum += minusArr.remove();
            }
        }

        sum += one;
        System.out.println(sum);
    }
}
