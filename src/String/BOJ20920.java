package String;

import java.io.*;
import java.util.*;

public class BOJ20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> {
            int freq1 = map.get(o1);
            int freq2 = map.get(o2);

            if (freq1 != freq2) return freq2 - freq1;                   // 1. 자주 나오는 순
            if (o1.length() != o2.length()) return o2.length() - o1.length(); // 2. 길이 긴 순
            return o1.compareTo(o2);                                     // 3. 사전순
        });

        for(String temp : list) {
            bw.write(temp + "\n");
        }

        bw.flush();
        bw.close();
    }
}
