package Hash;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class BOJ25192 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int answer = 0;
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            String s = scanner.next();
            if(!Objects.equals(s, "ENTER")) { // 엔터가 아니면
                set.add(s);
            }
            else { // 엔터면 set 클리어
                answer += set.size();
                set.clear();
            }
        }
        answer += set.size();

        System.out.println(answer);
    }
}
