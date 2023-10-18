class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] nums = number.toCharArray();
        int idx = 0;
        int t_k = k;
        while(idx < nums.length){
            int max = 0;
            int temp_idx = 0;
            for(int i = idx; i <= idx + t_k; ++i){
                if(i >= nums.length)break;
                if(nums[i] > max){
                    max = nums[i];
                    temp_idx = i;
                }
            }
            sb.append(nums[temp_idx]);
            t_k = t_k - (temp_idx - idx);
            idx = temp_idx + 1;
            if(sb.length() >= nums.length - k) break;
            if(k == 0) break;
        }
        if(idx < nums.length && sb.length() < nums.length - k){
            for(int i = idx; i < nums.length; ++i){
                sb.append(nums[i]);
            }
        }
        return sb.toString();
    }
}