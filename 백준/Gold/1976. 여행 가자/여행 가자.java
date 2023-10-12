import java.util.*;
import java.io.*;

public class Main {
    static int arr[];
    static int n,m;
    static int graph[][];
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        int dist[] = new int[m];
        arr = new int[n+1];
        for(int i = 1; i <= n; ++i){
            arr[i] = i;
        }
        for(int i = 1; i <= n; ++i){
            st = new StringTokenizer(buf.readLine());
            for(int j = 1; j <= n; ++j){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(buf.readLine());
        for(int i = 0; i < m; ++i){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                if(graph[i][j] == 1){
                    if(find(i) != find(j)){
                        union(i,j);
                    }
                }
            }
        }
        int check = arr[dist[0]];
        boolean ch = true;
        for(int i = 1; i < m; ++i){
              if(check != arr[dist[i]]) {
                  ch = false;
                  break;
              }
        }
        if(ch) System.out.println("YES");
        else System.out.println("NO");
    }
    public static int find(int a){
        if(arr[a] == a) return a;
        else return arr[a] = find(arr[a]);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(b >= a) arr[b] = a;
        else arr[a] = b;
    }
}