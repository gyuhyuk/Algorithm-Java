package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max Heap

        for(int i =0; i<n; i++){ // n번 반복
            int num = Integer.parseInt(br.readLine());

            if(minHeap.size() == maxHeap.size()) { // 사이즈가 같으면 max heap에 넣기
                maxHeap.offer(num);
            }
            else minHeap.offer(num); // 사이즈가 다르면 min Heap에 넣기

            if(!minHeap.isEmpty() && !maxHeap.isEmpty()) // 두개의 힙 모두 안비어 있고
                if(minHeap.peek() < maxHeap.peek()) { // 두 개 자리 바꾸기
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }

            sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb);
    }
}
