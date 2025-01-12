package Hash;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ26069 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");

        for(int i=0; i<N; i++) {
            String a = scanner.next();
            String b = scanner.next();

            if(set.contains(a) || set.contains(b)) {
                set.add(a);
                set.add(b);
            }
        }

        System.out.println(set.size());
    }
}
