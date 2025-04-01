package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        int temp = 0;
        if(Objects.equals(game, "Y")) {
            temp = 1;
        } else if (Objects.equals(game, "F")) {
            temp = 2;
        } else if (Objects.equals(game, "O")) {
            temp = 3;
        }

        Set<String> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            set.add(s);
        }

        System.out.println(set.size() / temp);
    }
}
