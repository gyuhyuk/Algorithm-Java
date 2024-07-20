package Greedy;

import java.util.*;

public class BOJ30457 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        ArrayList<Integer> originalArr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            originalArr.add(scanner.nextInt());
        }

        Set<Integer> uniqueSet = new HashSet<>();
        ArrayList<Integer> resultArr = new ArrayList<>();

        for (Integer num : originalArr) {
            if (uniqueSet.contains(num)) {
                resultArr.add(num);
            } else {
                uniqueSet.add(num);
            }
        }

        Set<Integer> finalSet = new HashSet<>(resultArr);
        ArrayList<Integer> answerArr = new ArrayList<>(finalSet);

        System.out.println(uniqueSet.size() + answerArr.size());
    }
}