import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_11725 {
    static ArrayList<Integer> tree[];
    public static void main(String []args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n+1];
        boolean visited[] = new boolean[n+1];
        for(int i=1; i<=n; ++i){
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; ++i){
            st = new StringTokenizer(buf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(1);
        int sol[] = new int[n+1];
        while(!dq.isEmpty()){
            int now = dq.removeFirst();
            visited[now] = true;
            for(int i=0; i<tree[now].size(); ++i){
                int next = tree[now].get(i);
                if(visited[next]) continue;
                sol[next] =now;
                dq.addLast(next);
                visited[next] = true;
            }
        }
        for(int i =2; i<sol.length; ++i){
            System.out.println(sol[i]);
        }
    }
}
