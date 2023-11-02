import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n+1][m+1];
        for(int i = 1; i <= n; ++i){
            st = new StringTokenizer(buf.readLine());
            for(int j = 1; j <= m; ++j){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= m; ++j) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + arr[i][j];
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= m; ++j) {
                for(int y = i; y <= n; ++y){
                    for(int x = j; x <= n; ++x){
                        answer = Math.max(answer, arr[y][x] - arr[y][j-1] - arr[i-1][x] + arr[i-1][j-1]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}