package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[100];

        for(int t=0; t<10; t++) {
            st = new StringTokenizer(br.readLine());
            int dump = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int j=0; j<dump; j++) {
                Arrays.sort(arr);
                if(arr[0] == arr[99]) {
                    break;
                }
                arr[0] = arr[0]+1;
                arr[99] = arr[99]-1;
            }
            Arrays.sort(arr);
            System.out.println("#" + (t+1) + " " + (arr[99] - arr[0]));
        }
    }
}
