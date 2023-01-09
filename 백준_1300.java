import java.util.*;


public class 백준_1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long start = 1; long end = k;
        long mid = 0;
        long count=0;
        long answer=0;
        while(start <= end){
            count=0;
            mid = (start+end)/2;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid/i,n);
            }
            if(count >= k){
                answer = mid;
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        System.out.println(answer);
    }
}
