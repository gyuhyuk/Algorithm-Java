package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            Deque<Integer> deque = new LinkedList<>();

            int user = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<8; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean stop = false;

            while (!stop) {
                for(int i=1; i<=5; i++) {
                    int temp = deque.poll();
                    if(temp - i <= 0) {
                        deque.addLast(0);
                        stop = true;
                        break;
                    } else {
                        deque.addLast(temp-i);
                    }
                }

                if(deque.peekLast() == 0) {
                    break;
                }
            }

            System.out.print("#" + t + " ");
            for(int i : deque) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
