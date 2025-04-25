package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA7102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N*M+1];


            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    arr[i+j]++;
                }
            }

            int max = 0;
            ArrayList<Integer> answer = new ArrayList<>();

            for(int i=1; i<=N+M; i++) {
                if(arr[i] > max) {
                    max = arr[i];
                    answer.clear();
                    answer.add(i);
                } else if(arr[i] == max) {
                    answer.add(i);
                }
            }

            Collections.sort(answer);

            System.out.print("#" + t + " ");
            for(int temp : answer) {
                System.out.print(temp + " ");
            }
            System.out.println();
        }
    }
}
