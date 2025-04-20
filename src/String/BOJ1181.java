package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            String string = br.readLine();
            set.add(string);
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        list.sort(Comparator.comparingInt(String::length));

        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
