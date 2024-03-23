package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coin = sc.nextInt();
        int goal = sc.nextInt();
        int cnt = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<coin; i++) {
            arr.add(sc.nextInt());
        }

        for(int i=coin-1; i>=0; i--) {
            if(arr.get(i) <= goal) {
                cnt += (goal / arr.get(i));
                goal %= arr.get(i);
            }
        }

        System.out.println(cnt);

    }
}
