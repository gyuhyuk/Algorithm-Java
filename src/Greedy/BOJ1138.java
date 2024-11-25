package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        boolean[] visit = new boolean[N];

        for(int i=0; i<N; i++) {
            int cnt = 0;
            int num = sc.nextInt();

            for(int j=0; j<N; j++) {
                if(!visit[j]) {
                    if(cnt == num) {
                        visit[j] = true;
                        arr[j] = i+1;
                        break;
                    }
                    cnt++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
}
