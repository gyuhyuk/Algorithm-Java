package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HSAT6268 {
    static final Map<Character, int[]> numberPosition = new HashMap<>();
    static {
        numberPosition.put(' ', new int[]{0, 0, 0, 0, 0, 0, 0});
        numberPosition.put('0', new int[]{1, 1, 0, 1, 1, 1, 1});
        numberPosition.put('1', new int[]{0, 1, 0, 0, 1, 0, 0});
        numberPosition.put('2', new int[]{1, 1, 1, 0, 0, 1, 1});
        numberPosition.put('3', new int[]{1, 1, 1, 0, 1, 1, 0});
        numberPosition.put('4', new int[]{0, 1, 1, 1, 1, 0, 0});
        numberPosition.put('5', new int[]{1, 0, 1, 1, 1, 1, 0});
        numberPosition.put('6', new int[]{1, 0, 1, 1, 1, 1, 1});
        numberPosition.put('7', new int[]{1, 1, 0, 1, 1, 0, 0});
        numberPosition.put('8', new int[]{1, 1, 1, 1, 1, 1, 1});
        numberPosition.put('9', new int[]{1, 1, 1, 1, 1, 1, 0});
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for(int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine());
            String beforeNum = st.nextToken();
            String afterNum = st.nextToken();

            int maxLen = Math.max(beforeNum.length(), afterNum.length());

            beforeNum = String.format("%" + maxLen + "s", beforeNum);
            afterNum = String.format("%" + maxLen + "s", afterNum);

            int result = 0;

            for(int j=0; j<maxLen; j++) {
                result += compare(beforeNum.charAt(j), afterNum.charAt(j));
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static int compare(char before, char after) {
        int clickCount = 0;
        int[] beforeState = numberPosition.get(before);
        int[] afterState = numberPosition.get(after);

        for(int i=0; i<7; i++) {
            if(beforeState[i] != afterState[i]) {
                clickCount++;
            }
        }

        return clickCount;
    }
}
