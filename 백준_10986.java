
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;


public class 백준_10986 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long sum[] = new long[n];
        sum[0] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + sc.nextInt();
        }
        long res=0;
        int rem=0;
        long reminder[] = new long[m];
        for (int i = 0; i < n; i++) {
            rem = (int) (sum[i]%m);
            if(rem == 0) {
                res++;
            }
            reminder[rem]++;
        }
        for (int i = 0; i < m; i++) {
            if(reminder[i] > 1){
                res = res + (reminder[i] *(reminder[i]-1) /2);
            }
        }
        System.out.println(res);
    }
}
