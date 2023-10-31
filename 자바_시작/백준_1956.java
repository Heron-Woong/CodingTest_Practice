import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1956 {
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        arr = new int[v+1][v+1];
        for(int i = 0; i<=v; ++i){
            for(int j = 0; j<=v; ++j){
                if(i == j) arr[i][j] = 0;
                else arr[i][j] = 987654321;
            }
        }
        for(int i =0; i<e; ++i){
            st = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }
        for(int m = 1; m <= v; ++m){
            for(int s = 1; s<=v; ++s){
                for(int en = 1; en <=v; ++ en){
                    if(arr[s][en] >= arr[s][m] + arr[m][en]){
                        arr[s][en] = arr[s][m] + arr[m][en];
                    }
                }
            }
        }
        int result = 987654321;
        for(int i = 1; i<=v; ++i){
            for(int j =1; j<=v; ++j){
                if(arr[i][j] != 987654321 && arr[j][i] != 987654321 && i!=j){
                    result = Math.min(result, arr[i][j] + arr[j][i]);
                }
            }
        }
        if(result == 987654321){
            System.out.println(-1);
        }
        else System.out.println(result);
    }
}
