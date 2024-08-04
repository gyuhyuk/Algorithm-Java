package Math;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2562 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<9; i++) {
            arr.add(scanner.nextInt());
        }
        int temp = 0;

        for(int i=0; i<9; i++) {
            temp = Math.max(temp, arr.get(i));
        }


        System.out.println(temp);
        System.out.println(arr.indexOf(temp)+1);
    }
}
