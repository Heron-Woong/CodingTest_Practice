import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        int nums[] = new int[n+1];
        int delta[] = new int[n+2];
        int acc[] = new int[n+2];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(buf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            delta[s] += k;
            delta[e+1] += -1 * k;
        }
        for (int i = 1; i < n+2; i++) {
            acc[i] = acc[i-1] + delta[i];
        }
        for (int i = 1; i < n+1; i++) {
            nums[i] += acc[i];
        }
        for (int i = 1; i < n+1; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}