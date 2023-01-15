import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][4];
        for(int i=0; i<n; ++i){
            st = new StringTokenizer(buf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }
        int sum[][] = new int[2][n*n];
        int index =0;
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j) {
                sum[0][index] = arr[i][0] + arr[j][1];
                sum[1][index] = arr[i][2] + arr[j][3];
                ++index;
            }
        }
        Arrays.sort(sum[0]);
        Arrays.sort(sum[1]);
        int start =0; int end = n*n-1;
        long answer =0;
        while(true){
            int now = sum[0][start] + sum[1][end];
            int startCnt=1;
            int secondCnt=1;
            if(now == 0) {
                while(start <= (n*n)-2 && sum[0][start] == sum[0][start+1]){
                    ++start;
                    ++startCnt;
                }
                while(0 < end && sum[1][end] == sum[1][end-1]){
                    --end;
                    ++secondCnt;
                }
                answer += (long) startCnt*secondCnt;
            }
            if(now > 0) end--;
            else start++;
            if(start >= n*n || end < 0) break;
        }
        System.out.println(answer);
    }
}
