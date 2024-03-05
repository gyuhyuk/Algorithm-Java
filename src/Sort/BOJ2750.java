package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ2750 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int user = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<user; i++) {
            list.add(scanner.nextInt());
        }

        Collections.sort(list);

        for(int i=0; i< list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
