import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_11437 {
    static ArrayList<Integer> tree[];
    static boolean visited[];
    static int parent[];
    static int depth[];

    public static int LCS(int u, int v){
        while(true){
            if(depth[u] > depth[v]){
                u = parent[u];
            }
            else if(depth[u] < depth[v]){
                v = parent[v];
            }
            else break;
        }
        while(true){
            if(u == v) break;
            u = parent[u];
            v = parent[v];
        }
        return u;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        depth = new int[n+1];
        parent = new int[n+1];
        for(int i =1; i<n+1; ++i){
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; ++i) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(1);
        depth[1] = 0;
        parent[1] = 0;
        while(!dq.isEmpty()){
            int now = dq.removeFirst();
            visited[now] = true;
            for(int i =0; i<tree[now].size(); ++i){
                int next = tree[now].get(i);
                if(visited[next]) continue;
                parent[next] = now;
                depth[next] = depth[now]+1;
                dq.addLast(next);
            }
        }
        st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i< m; ++i){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            System.out.println(LCS(u,v));
        }
    }
}
