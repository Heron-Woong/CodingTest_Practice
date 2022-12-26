import java.util.Scanner;

public class 백준_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start_idx=1; int end_idx=1;
        int count=1;
        int sum=1;
        while(end_idx != n){
            if(sum < n){
                end_idx++;
                sum += end_idx;
            }
            else if(sum > n){
                sum -= start_idx;
                ++start_idx;
            }
            else{
                ++count;
                ++end_idx;
                sum += end_idx;
            }
        }
        System.out.println(count);
    }
}
