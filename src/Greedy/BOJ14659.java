package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ14659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = Integer.MIN_VALUE;

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            arr.add(sc.nextInt());
        }

        for(int i=0; i<N; i++) {
            int cnt = 0;
            int temp = arr.get(i);
            for(int j=i+1; j<N; j++) {
                if(temp < arr.get(j)) {
                    break;
                }
                else {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}
