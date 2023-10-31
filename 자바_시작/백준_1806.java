import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1806 {
    public static void main(String [] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        int pro[] = new int[n+1];
        for(int i =0; i<n;  ++i){
            pro[i] = Integer.parseInt(st.nextToken());
        }
        int first = 0;
        int second = 0;
        int sum = 0;
        int result= Integer.MAX_VALUE;
        int count = 1;
        boolean check = false;
        while(second <= n) {
            if(sum >= s)  {
                sum -= pro[first++];
                count = second - first + 1;
                result = Math.min(result, count);
                check = true;
            }
            else if(sum < s){
                sum += pro[second++];
            }
        }
        if(check)  System.out.println(result);
        else System.out.println(0);
    }
}
