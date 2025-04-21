package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> listenSet = new HashSet<>();
        List<String> answerList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            listenSet.add(br.readLine());
        }

        for(int i=0; i<M; i++) {
            String s = br.readLine();
            if(listenSet.contains(s)) {
                answerList.add(s);
            }
        }

        Collections.sort(answerList);

        System.out.println(answerList.size());
        for(int i=0; i<answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
    }
}
