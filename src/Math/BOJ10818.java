package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ10818 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<a; i++) {
            arr.add(scanner.nextInt());
        }

        Collections.sort(arr);

        System.out.println(arr.get(0) + " " + arr.get(arr.size()-1));
    }
}
