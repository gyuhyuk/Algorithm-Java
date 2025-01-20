package Sort;

import java.util.*;

public class BOJ1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            // 빈도수 업데이트
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }

        // 가장 높은 빈도를 찾기
        int maxCount = Collections.max(hashMap.values());

        // 빈도가 maxCount인 항목을 사전순으로 정렬하여 첫 번째 값 출력
        String result = hashMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxCount) // 최대 빈도만 필터링
                .map(Map.Entry::getKey) // 키 값만 추출
                .sorted() // 사전순 정렬
                .findFirst() // 첫 번째 값 선택
                .orElse(null); // 값이 없으면 null 반환

        System.out.println(result);
    }
}
