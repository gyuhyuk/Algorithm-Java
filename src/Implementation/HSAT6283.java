package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HSAT6283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<8; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;

        for(int i=0; i<7; i++) {
            int now = arr.get(i);
            int next = arr.get(i+1);
            if(next == now+1) { // 다음 값이 현재값 +1
                count++;
            }
            else if(next == now-1) { // 다음 값이 현재값 -1
                count--;
            }
        }

        if(count == 7) {
            System.out.println("ascending");
        }
        else if(count == -7) {
            System.out.println("descending");
        }
        else {
            System.out.println("mixed");
        }
    }
}
