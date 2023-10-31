import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1717 {
    static int arr[];
    public static void main(String []args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr= new int[n+1];
        for(int i =0; i<=n; ++i){
            arr[i] = i;
        }
        for(int i = 0; i <m; ++i){
            st = new StringTokenizer(buf.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(t == 0){
                union(a,b);
            }
            else{
                if(find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;
        arr[b] = a;
    }
    public static int find(int a){
        if(arr[a] == a) return a;
        else{
            return arr[a] = find(arr[a]);
        }
    }
}
