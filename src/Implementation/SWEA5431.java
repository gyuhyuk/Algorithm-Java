package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA5431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ArrayList<Integer> studentArr = new ArrayList<>();
            ArrayList<Integer> notSubmit = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<K; i++) {
                notSubmit.add(Integer.parseInt(st.nextToken()));
            }

            for(int i=1; i<=N; i++) {
                if(!notSubmit.contains(i)) {
                    studentArr.add(i);
                }
            }

            System.out.print("#" + t + " ");

            for(int i : studentArr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
