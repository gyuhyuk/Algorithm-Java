package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA6719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            double answer = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<Integer> answerArr = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arr, Collections.reverseOrder());

            for(int i=0; i<K; i++) {
                answerArr.add(arr.get(i));
            }

            for(int i=answerArr.size()-1; i>=0; i--) {
                answer = (answerArr.get(i) + answer) / 2;
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}
