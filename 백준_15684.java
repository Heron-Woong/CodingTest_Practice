import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15684 {
    static int arr[][];
    static int result=0;
    static int n,h,m;
    static boolean finish = false;
    public static void main(String []args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+1][n+1];
        for(int i =0; i<h; ++i) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = 1;
            arr[u][v + 1] = 2;
        }
        for(int i =0; i<= 3; ++i ){
            result = i;
            plus(0);
            if(finish) break;
        }
        if(finish) System.out.println(result);
        else System.out.println(-1);
    }
    public static void plus(int count){
        if(finish) return;
        if(result == count) {
            if(check()) finish = true;
            else finish = false;
            return;
        }
        for(int i = 1; i<=m; ++i){
            for(int j=1; j< n; ++j){
                if(arr[i][j] == 0 && arr[i][j+1] == 0){
                    arr[i][j] = 1;
                    arr[i][j+1] =2;
                    plus(count+1);
                    arr[i][j] = 0;
                    arr[i][j+1] = 0;
                }
            }
        }
    }
    public static boolean check() {
        for (int i = 1; i <= n; ++i) {
            int ny = 1;
            int nx = i;
            while (ny <= m) {
                if (arr[ny][nx] == 1) ++nx;
                else if (arr[ny][nx] == 2) --nx;
                ++ny;
            }
            if (nx != i) return false;
        }
        return true;
    }
}
