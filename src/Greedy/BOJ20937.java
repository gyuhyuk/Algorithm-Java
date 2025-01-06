package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20937 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        int result = 1;
        int count = 1;

        for(int i=1; i<N; i++) {
            if(arr.get(i).equals(arr.get(i-1))) {
                count++;
                result = Math.max(result, count);
            }
            else {
                count = 1;
            }
        }

        System.out.println(result);
    }
}
