import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(buf.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int e = 0;
        int answer = arr[n - 1] - arr[0];
        for(int i = 0; i < n; ++i) {
            while(arr[e] - arr[i] < m && e < n - 1) {
                e++;
            }
            int diff = arr[e] - arr[i];
            if(diff >= m) {
                answer = Math.min(answer, diff);
            }
        }
        
        System.out.println(answer);
    }
}