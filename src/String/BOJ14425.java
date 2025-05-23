package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            set.add(s);
        }

        for(int i=0; i<M; i++) {
            String s = br.readLine();
            if(set.contains(s)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
