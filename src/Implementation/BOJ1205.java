package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1205 {
    static int N, X, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if(N == 0) { // 0이면 1출력 후 종료
            System.out.println(1);
            System.exit(0);
        }

        ArrayList<Integer> arr = new ArrayList<>(); // index 1부터 사용

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        if(arr.size() == P) { // 리스트가 차있으면,
            if(arr.get(arr.size()-1) >= X) { // 새로 들어온 태수 점수가 배열 마지막 값보다 작거나 같으면
                System.out.println(-1); // -1 출력후 종료
                System.exit(0);
            }
            else {
                arr.remove(arr.size()-1); // 가장 작은 것 없애기
                arr.add(X); // 태수 점수추가
                arr.sort(Collections.reverseOrder()); // 내림차순 정렬
                System.out.println(arr.indexOf(X)+1);
                System.exit(0);
            }
        }
        else { // 리스트 안 차있으면
            arr.add(X); // 태수 점수 추가
            arr.sort(Comparator.reverseOrder()); // 내림차순 정렬
            System.out.println(arr.indexOf(X)+1);
            System.exit(0);
        }
    }
}
