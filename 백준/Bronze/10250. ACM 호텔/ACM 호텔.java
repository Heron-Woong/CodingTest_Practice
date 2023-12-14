import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(buf.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(checkSol(h,w,n));
        }
    }
    public static String checkSol (int h, int w, int n) {
        int x,y = 0;
        if(n % h == 0) {
            y = h;
            x = n / h;
        }
        else {
            y = n % h;
            x = n / h + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(y);
        if(x >= 10) sb.append(x);
        else {
            sb.append(0);
            sb.append(x);
        }
        return sb.toString();
    }
}
