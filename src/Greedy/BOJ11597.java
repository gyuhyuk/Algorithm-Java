package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ11597 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arrayList.add(scanner.nextInt());
        }

        Collections.sort(arrayList);

        int minIndex = 0;
        int maxIndex = N - 1;

        int answer = arrayList.get(minIndex) + arrayList.get(maxIndex);
        int temp;

        while (minIndex < maxIndex) {
            temp = arrayList.get(minIndex) + arrayList.get(maxIndex);
            answer = Math.min(temp, answer);
            minIndex++;
            maxIndex--;
        }

        System.out.println(answer);
    }
}
