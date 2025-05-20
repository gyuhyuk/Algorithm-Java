package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA10580 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<int[]> arr = new ArrayList<>();
            int count = 0;

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                arr.add(new int[]{A, B});
            }
            for(int j=0; j<N-1; j++) {
                for(int k=N-1; k>j; k--) {
                    if((arr.get(j)[0] > arr.get(k)[0] && arr.get(j)[1] < arr.get(k)[1]) || (arr.get(j)[0] < arr.get(k)[0] && arr.get(j)[1] > arr.get(k)[1])) {
                        count++;
                    }
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}
