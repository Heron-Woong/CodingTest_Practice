import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean y[] = new boolean[n];
        boolean x[] = new boolean[m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                if(str.charAt(j) == 'X') {
                    y[i] = true;
                    x[j] = true;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!y[i] && !x[j]){
                    y[i] = true;
                    x[j] = true;
                    ++result;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(!y[i]) result++;
        }
        for (int i = 0; i < m; i++) {
            if(!x[i]) result++;
        }
        System.out.println(result);
    }
}