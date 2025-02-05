package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSAT6279 {
    static int count = 0;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        char[] data = new char[N];

        st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        for(int i=0; i<N; i++) {
            data[i] = input.charAt(i); // char 하나씩 대입
        }

        for(int i=0; i<N; i++) {
            if(data[i] == 'P') { // 로봇
                for(int j=i-K; j<=i+K; j++) { // 양팔 길이만큼
                    if(j < 0 || j >= N) {
                        continue;
                    }
                    if(data[j] == 'H') {
                        data[j] = 'O';
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
