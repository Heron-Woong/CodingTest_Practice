import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long arr[] = new long[n];
        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(buf.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long s = 1;
        long e = arr[n-1];
        long result = 0;
        while(s <= e){
            long m = (s + e) / 2;
            long tempCount = checkNum(m, arr);
            if(tempCount < k) {
                e = m - 1;
            }
            else if (tempCount >= k) {
                s = m + 1;
                result = Math.max(result, m);
            }
        }
        System.out.println(result);
    }
    public static long checkNum(long num, long arr[]) {
        long count = 0;
        for(int i = 0; i < arr.length; ++i) {
            count += (arr[i] / num);
        }
        return count;
    }

}