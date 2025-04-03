package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA2068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        int T = Integer.parseInt(st.nextToken());

        for(int i=1; i<=T; i++) {
            arr.clear();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr.add(n);
            }
            System.out.println("#" + i + " " + Collections.max(arr));
        }
    }
}
