package Math;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ3052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<10; i++) {
           int N = scanner.nextInt();

           int temp = N % 42;

           if(!arr.contains(temp)) {
               arr.add(temp);
           }
        }

        System.out.println(arr.size());
    }
}
