import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_4781 {
    public static void main(String [] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sub = new StringBuffer();
        while(true){
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int n = Integer.parseInt(st.nextToken());
            double temp_m = Double.parseDouble(st.nextToken());
            temp_m *= 100; temp_m += 0.5;
            int m = (int) temp_m;
            if(n==0 && m== 0) break;
            int dp[] = new int[m + 1];
            for(int i=0; i<n; ++i) {
                st = new StringTokenizer(buf.readLine());
                int calorie = Integer.parseInt(st.nextToken());
                double temp = Double.parseDouble(st.nextToken());
                temp *= 100;
                temp += 0.5;
                int num = (int) temp;
                if(num > m) continue;
                for (int j = num; j < m + 1; ++j) {
                    dp[j] = Math.max(dp[j], dp[j - num] + calorie);
                }
            }
            sub.append(dp[m] +"\n");
        }
        System.out.print(sub);
    }
}
