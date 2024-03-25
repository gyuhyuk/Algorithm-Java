package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ22993 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int user = sc.nextInt();

        List<Long> list = new ArrayList<>();

        for(int i=0; i<user; i++) {
            list.add(sc.nextLong());
        }

        long jun = list.get(0);
        list.remove(0);

        Collections.sort(list);

        for(int i=1; i<user; i++) {
            if(jun > list.get(i-1)) {
                jun += list.get(i-1);
            }
            else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
