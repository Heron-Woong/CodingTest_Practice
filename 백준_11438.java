import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_11438 {
    static ArrayList<Integer> arr[];
    static int depth[];
    static boolean visited[];
    static int parent[][];
    static int dMax;
    public static void main(String []args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        depth = new int[n+1];
        visited = new boolean[n+1];
        depth[1] = 0;
        int temp = 1;
        dMax = 0;
        while(temp <= n){
            temp <<= 1;
            dMax++;
        }
        parent = new int[dMax + 1][n+1];
        for(int i = 1; i < n+1; ++i){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i<n-1; ++i){
            st = new StringTokenizer(buf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(1);
        while(!dq.isEmpty()){
            int now = dq.removeFirst();
            visited[now] = true;
            for(int i =0; i<arr[now].size(); ++i){
                int next = arr[now].get(i);
                if(visited[next]) continue;
                visited[next] = true;
                dq.addLast(next);
                parent[0][next] = now;
                depth[next] = depth[now]+1;
            }
        }
        for(int k =1; k <= dMax; k++){
            for(int s =1; s <= n; ++s){
                parent[k][s] = parent[k-1][parent[k-1][s]];
            }
        }
        int m = Integer.parseInt(buf.readLine());
        for(int i =0; i<m; i++){
            st = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = LCA(a,b);
            System.out.println(lca);
        }
    }
    public static int LCA(int a, int b){
        if(depth[a] > depth[b]){
            int temp = a;
            a = b;
            b= temp;
        }
        for(int k = dMax; k >= 0; k--){
            if(Math.pow(2, k) <= depth[b]-depth[a]){
                if(depth[a] <= depth[parent[k][b]]){
                    b = parent[k][b];
                }
            }
        }
        for(int k = dMax; k >= 0; k--){
            if(parent[k][a] != parent[k][b]){
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int LCA = a;
        if(a != b) LCA = parent[0][LCA];
        return LCA;
    }
}
