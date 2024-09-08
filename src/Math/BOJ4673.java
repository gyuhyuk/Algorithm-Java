package Math;

public class BOJ4673 {
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];

        for(int i=1; i<10000; i++) {
            int s = i; // 생성자 자기 자신을 더하는 로직

            char[] temp = String.valueOf(i).toCharArray();

            // 각 자리 수 숫자 더하는 로직
            for(int j=0; j<temp.length; j++) {
                s += Integer.parseInt(String.valueOf(temp[j]));
            }

            if(s < 10001) {
                check[s] = true;
            }

        }
            for(int i=1; i<10000; i++) {
             if(!check[i]) {
                 System.out.println(i);
             }
        }
    }
}
