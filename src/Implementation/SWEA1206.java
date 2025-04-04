package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            int building = Integer.parseInt(st.nextToken());
            int[] arr = new int[building];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<building; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;

            for(int k=2; k<=arr.length-3; k++) {
                        int max = Math.max(Math.max(arr[k-2], arr[k-1]), Math.max(arr[k+1], arr[k+2]));
                        if(arr[k] > max) {
                            answer += arr[k] - max;
                        }
            }

            System.out.println("#" + (i+1) + " " + answer);
        }
    }
}
