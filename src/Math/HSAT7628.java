package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HSAT7628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr.add(Integer.parseInt(st.nextToken())); // 배열에 하나씩 담기
        }

        for(int i=2; i<=100; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(arr.get(j) % i == 0) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }

        System.out.print(max);
    }
}
