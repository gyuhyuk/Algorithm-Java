package Greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CodeUp2001 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> pasta = new ArrayList<>();
        ArrayList<Integer> juice = new ArrayList<>();

        double answer = 0;

        for(int i=0; i<3; i++) {
            pasta.add(scanner.nextInt());
        }

        for(int i=0; i<2; i++) {
            juice.add(scanner.nextInt());
        }

        Collections.sort(pasta);
        Collections.sort(juice);

        answer += pasta.get(0) + juice.get(0) + ((pasta.get(0) + juice.get(0)) * 0.1);

        System.out.println(answer);
    }
}
