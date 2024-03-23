package TwoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ1253 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            arr.add(scanner.nextInt());
        }

        Collections.sort(arr);

        for(int k=0; k<N; k++) {
            int find = arr.get(k);
            int i=0;
            int j=N-1;

            while(i<j) {
                if(arr.get(i) + arr.get(j) == find) {
                    if(i != k && j != k) {
                        answer++;
                        break;
                    } else if (i == k) {
                        i++;
                    }
                    else {
                        j--;
                    }
                } else if (arr.get(i) + arr.get(j) < find) {
                    i++;
                }
                else {
                    j--;
                }
            }
        }
        System.out.println(answer);
        scanner.close();
    }
}
