package Stack;

import java.util.*;

public class BOJ30892 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextInt();
        long K = scanner.nextInt();
        long T = scanner.nextInt();

        ArrayList<Long> arrayList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            arrayList.add(scanner.nextLong());
        }

        Collections.sort(arrayList);

        Stack<Long> stack = new Stack<>();
        Queue<Long> queue = new LinkedList<>();

        for(int i=0; i<N; i++) {
            if(arrayList.get(i) < T) {
                stack.push(arrayList.get(i));
            }

            else {
                queue.add(arrayList.get(i));
            }
        }

        for(int i=0; i<K; i++) {
            if(stack.isEmpty()) {
                break;
            }

            else {
                long top = stack.pop();
                T += top;
                while (!queue.isEmpty() && T > queue.peek()) {
                    long next = queue.poll();
                    stack.push(next);
                }
            }
        }

        System.out.println(T);
    }
}
