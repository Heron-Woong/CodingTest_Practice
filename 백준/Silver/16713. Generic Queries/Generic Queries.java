import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        int pro[] = new int[n+1];
        st = new StringTokenizer(buf.readLine());
        for(int i = 0; i < n; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        pro[1] = arr[0];
        for(int i = 2; i <= n; ++i){
            pro[i] = pro[i-1] ^ arr[i-1];
        }

        int s = 0;
        int e = 0;
        int ans = 0;
        for(int i = 0; i < q; ++i) {
            st = new StringTokenizer(buf.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            ans ^= pro[e] ^ pro[s-1];
        }
        System.out.println(ans);
    }
    
}