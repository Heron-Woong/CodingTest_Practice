import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        int arr[] = new int[n];

        for(int i = 0; i < n; ++i) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        
        int rightIndex = 0;
        int currentSum = arr[0];
        int answer = n+1;

        for(int i = 0; i < n; i++) {
            while(currentSum < m && rightIndex < n - 1) {
                currentSum += arr[++rightIndex];
            }
            if(currentSum >= m) {
                answer = Math.min(answer, rightIndex - i + 1);
            }
            currentSum -= arr[i];
        }

        if(answer > n) System.out.println(0);
        else System.out.println(answer);
    }
}
