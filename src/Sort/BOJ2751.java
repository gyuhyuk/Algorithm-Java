package Sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr =new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        for(int i=0; i<arr.size(); i++) {
            sb.append(arr.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
