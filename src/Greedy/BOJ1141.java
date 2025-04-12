package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            arr.add(s);
        }
        Collections.sort(arr, Collections.reverseOrder()); // 정렬

        ArrayList<String> result = new ArrayList<>();

        for(String s : arr) {
            boolean isPrefix = false;
            for(String prefix : result) {
                if(prefix.startsWith(s)) {
                    isPrefix = true;
                    break;
                }
            }

            if(!isPrefix) result.add(s);
        }

        System.out.println(result.size());
    }
}
