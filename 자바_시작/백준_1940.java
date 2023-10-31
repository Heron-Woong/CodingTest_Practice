import java.util.Arrays;
import java.util.Scanner;

public class 백준_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int start_idx = 0; int end_idx = n-1;
        int count =0;
        while(start_idx < end_idx){
           if(arr[start_idx] + arr[end_idx] > m){
               --end_idx;
           }
           else if(arr[start_idx] + arr[end_idx] < m){
               ++start_idx;
            }
           else{
               ++count;
               ++start_idx;
               --end_idx;
           }
        }
        System.out.println(count);
    }
}
//1940
//1253
