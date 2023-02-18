import java.io.IOException;
import java.util.Scanner;


public class 백준_2166 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] x = new long[n+1];
        long[] y = new long[n+1];
        for(int i=0; i< n; ++i){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        x[n]=x[0];
        y[n]=y[0];
        double result = 0;
        for(int i =0; i<n; ++i){
            result += (x[i]*y[i+1])- (x[i+1]*y[i]);
        }
        String answer =String.format("%.1f", Math.abs(result)/2.0);
        System.out.println(answer);
    }
}
