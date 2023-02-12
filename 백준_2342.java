import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2342 {
    public static void main(String []args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int dp [][][] = new int[100001][5][5];
        int mp [][] = {
                {0,2,2,2,2},
                {2,1,3,4,3},
                {2,3,1,3,4},
                {2,4,3,1,3},
                {2,3,4,3,1}};
        int s = 1;
        for(int i =0; i<5; ++i){
            for(int j =0; j<5; ++j){
                for(int k =0; k<100001; ++k){
                    dp[k][i][j] = 100001 * 4;
                }
            }
        }
        dp[0][0][0] = 0;
        while(true){
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) break;
            for(int i =0; i<5; ++i){
                if(i == num) continue;
                for(int j=0; j<5; ++j){
                    dp[s][i][num] = Math.min(dp[s-1][i][j] + mp[j][num], dp[s][i][num]);
                }
            }
            for(int i =0; i<5; ++i){
                if(i == num) continue;
                for(int j=0; j<5; ++j){
                    dp[s][num][i] = Math.min(dp[s-1][j][i] + mp[j][num], dp[s][num][i]);
                }
            }
            s++;
        }
        s--;
        int min = Integer.MAX_VALUE;
        for(int i =0; i<5; ++i){
            for(int j =0; j<5; ++j){
                min = Math.min(min, dp[s][i][j]);
            }
        }
        System.out.println(min);
    }
}
