package Math;

public class SWEA3131 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for(int i=2; i<=1000000; i++) {
            if(isPrime(i)) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static boolean isPrime(int x) {
        for(int i=2; i<=Math.sqrt(x); i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
