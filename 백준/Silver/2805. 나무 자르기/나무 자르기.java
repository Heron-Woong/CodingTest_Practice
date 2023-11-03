import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long min = Long.MAX_VALUE;
        long max = 0;
        st = new StringTokenizer(buf.readLine());
        long arr[] = new long[n];
        for(int i = 0; i < n; ++i) {
            long num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);
        System.out.println(find(min, max, arr, m));
    }
    public static long check(long arr[], long mid) {
        long sum = 0;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] > mid) {
                sum += (arr[i] - mid);
            }
        }
        return sum;
    }
    public static long find(long min, long max, long arr[], long m) {
        long left = 1;
        long right = max;
        long index = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            if(check(arr,mid) < m) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
                index = mid;
            }
        }
        return index;
    }
}