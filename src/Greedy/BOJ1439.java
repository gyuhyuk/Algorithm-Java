package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st1 = new StringTokenizer(s, "0"); // 0이 나올때 까지는 1의 토큰 개수에 저장
        StringTokenizer st0 = new StringTokenizer(s, "1"); // 1이 나올때 까지는 0의 토큰 개수에 저장
        System.out.println(Math.min(st1.countTokens(), st0.countTokens())); // 최솟값을 도출
    }
}
