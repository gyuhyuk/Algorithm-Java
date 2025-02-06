package Implementation;

import java.util.*;
import java.io.*;

public class HSAT6269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String s1 = br.readLine();
        String s2 = br.readLine();

        if(s2.contains(s1)) {
            System.out.println("secret");
        }
        else {
            System.out.println("normal");
        }
    }
}
