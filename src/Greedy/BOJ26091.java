package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ26091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrayList);

        int minIndex = 0;
        int maxIndex = arrayList.size() - 1;

        int answer = 0;

        while (minIndex < maxIndex) {
            int min = arrayList.get(minIndex);
            int max = arrayList.get(maxIndex);

            if (min + max >= M) {
                answer++;
                minIndex++;
                maxIndex--;
            } else {
                minIndex++;
            }
        }

        System.out.println(answer);
    }
}
