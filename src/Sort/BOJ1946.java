package Sort;

import java.util.Scanner;

public class BOJ1946 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 몇번 진행할것인가

        for(int i=0; i<N; i++) {
            int person = scanner.nextInt();
            int count = 1;

            int[] arr = new int[person+1];

            for(int j=0; j<person; j++) {
                int documentRank = scanner.nextInt();
                int interviewRank = scanner.nextInt();

                arr[documentRank] = interviewRank;
            }

            int x = arr[1];

            for(int k=2; k<=person; k++) {
                if(arr[k] < x) {
                    x = arr[k];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
