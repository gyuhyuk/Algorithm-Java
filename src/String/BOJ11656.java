package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Set<String> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            set.add(s.substring(i));
        }

        List<String> list = new ArrayList<>(set);

        Collections.sort(list);

        for(String temp : list) {
            System.out.println(temp);
        }
    }
}
