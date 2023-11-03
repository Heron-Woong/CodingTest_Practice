import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(buf.readLine());
        for(int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        st = new StringTokenizer(buf.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < m; ++i) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(upperBound(arr, num) - lowerBound(arr, num) + " ");
        }
        bw.flush();
    }
    public static int lowerBound(int arr[], int num) {
        int left = 0;
        int right = arr.length - 1;
        int index = arr.length;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] < num) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                index = mid;
            }
        }
        return index;
    }

    public static int upperBound(int arr[], int num) {
        int left = 0;
        int right = arr.length - 1;
        int index = arr.length;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] <= num) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                index = mid;
            }
        }
        return index;
    }
}