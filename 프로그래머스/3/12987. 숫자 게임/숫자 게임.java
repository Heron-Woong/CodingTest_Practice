import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(A);
        Arrays.sort(B);
        int j = B.length - 1;
        for(int i = 0; i < A.length; ++i){
            while(j >= 0 && A[i] < B[j]){
                pq.add(B[j]);
                --j;
            }
            if(pq.isEmpty()) break;
            while(pq.peek() < A[i]){
                pq.poll();
                if(pq.isEmpty()) break;
            }
            if(!pq.isEmpty()) {
                pq.poll();
                ++answer;
            };
        }
        return answer;
    }
}