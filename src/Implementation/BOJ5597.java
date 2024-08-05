package Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ5597 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=1; i<=30; i++) {
            arr.add(i);
        }

        for(int i=0; i<28; i++) {
            int input = scanner.nextInt();
            arr.remove(Integer.valueOf(input));
        }

        Collections.sort(arr);

        for(int i=0; i<arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
