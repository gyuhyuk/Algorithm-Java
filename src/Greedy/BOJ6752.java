package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ6752 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int time = scanner.nextInt();
        int housework = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<housework; i++) {
            arr.add(scanner.nextInt());
        }

        Collections.sort(arr);

        int sum = 0;
        int cnt = 0;

        for(int i=0; i<arr.size(); i++) {
            sum += arr.get(i);
            if(sum > time) {
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
