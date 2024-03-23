package Sort;
import java.util.*;

public class BOJ1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        String user = sc.nextLine();

        char[] arr = user.toCharArray();

        ArrayList<Integer> intArr = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            intArr.add(Integer.parseInt(String.valueOf(arr[i])));
        }

        Collections.sort(intArr, Collections.reverseOrder());

        for(int i=0; i<intArr.size(); i++) {
            sb.append(intArr.get(i));
        }

        System.out.println(sb);

        sc.close();
    }
}




