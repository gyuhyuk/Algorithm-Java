package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if(isPalindrome(s)) {
            System.out.println(s.length());
            return;
        }

        for(int i=0; i<s.length(); i++) {
            if(isPalindrome(s.substring(i))) {
                System.out.println(s.length()+i);
                return;
            }
        }
    }
    static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}