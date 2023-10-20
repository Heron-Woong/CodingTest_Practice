import java.util.*;

class Solution {
    static ArrayList<Integer> arr = new ArrayList<>();
    public int[] solution(int n, int s) {
        if(s / n == 0) return new int[] {-1};
        int answer[] = new int[n];
        int rest = s % n;
        for(int i = 0; i < n; ++i){
            answer[i] = s / n;
        }
        if(rest == 0){
            return answer;
        }
        while(rest != 0){
            for(int i = answer.length-1; i > 0; --i){
                answer[i]++;
                rest--;
                if(rest == 0) break;
            }
        }
        return answer;
    }
    
}