import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14003 {
    static int maxLength;
    static int []a; //받은 수열
    static int []b; //현재 index 숫자 저장
    static int []d; //몇번째인지 저장
    static int ans[];
    public static void main(String []args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        a = new int[1000001];
        b = new int[1000001];
        d = new int[1000001];
        ans = new int[1000001];
        st = new StringTokenizer(buf.readLine());
        for(int i =1; i<=n; ++i){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int index = 0;
        b[++maxLength] = a[1];
        d[1] = 1;
        for(int i =2; i<=n; ++i){
            if(b[maxLength] < a[i]){
                b[++maxLength] = a[i];
                d[i] = maxLength;
            }else{
                index =binarySearch(1,maxLength,a[i]);
                b[index] = a[i];
                d[i] = index;
            }
        }
        System.out.println(maxLength);
        index = maxLength;
        int x = b[maxLength]+1;
        for(int i = n; i >= 1; --i){
            if(d[i] == index && a[i] < x){
                ans[index] = a[i];
                x = a[i];
                --index;
            }
        }
        for(int i = 1; i<=maxLength; ++i){
            System.out.print(ans[i] + " ");
        }

    }
    public static int binarySearch(int l, int r, int now){
        int mid;
        while(l < r){
            mid = (l+r)/2;
            if(b[mid] < now){
                l = mid+1;
            }
            else r = mid;
        }
        return l;
    }
}
