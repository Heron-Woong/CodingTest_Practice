class Solution {
    static int cnt = Integer.MAX_VALUE;
    static int oneb = Integer.MAX_VALUE;
    public int[] solution(int target) {
        int[] answer = new int[2];
        sol(target, 0, 0, 0, 0);
        answer[0] = cnt;
        answer[1] = oneb;
        return answer;
    }
    public static void sol(int score, int one, int two, int three, int bool){
        if(score < 0) return;
        if(score == 0){
            if(cnt == one+two+three+bool){
                if(oneb < one+bool) oneb = one + bool;
            }
            else if(cnt > one+two+three+bool){
                cnt = one+two+three+bool;
                oneb = one + bool;
            }
            return;
        }
        if(score <= 20) {
            sol(0, one+1, two, three, bool);
        }
        else{
            sol(score - 50, one, two, three, bool+1);
            if(score / 20 != 0){
                sol(score - (score/20 * 20), one + score/20, two, three, bool);
            }
            if(score / 2 <= 20){
                sol(score - (score/2 * 2), one, two+1, three, bool);
            }
            else {
                sol(score - (score/40*40),one, two + (score/40), three, bool);
            }
            if(score / 3 <= 20){
                sol(score - (score/3 * 3), one, two, three+1, bool);
            }
            else {
                sol(score-(score/60*60),one, two, three + (score/60), bool);
            }
        }
    }
}