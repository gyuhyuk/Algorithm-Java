package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA7829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int P = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<P; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arr);

            if(arr.size() == 1) {
                System.out.println("#" + t + " " + (arr.get(0) * arr.get(0)));
            } else {
                System.out.println("#" + t + " " + (arr.get(0) * arr.get(arr.size() - 1)));
            }
        }
    }
}
