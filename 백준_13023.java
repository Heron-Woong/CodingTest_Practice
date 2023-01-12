import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_13023 {
    static  ArrayList<Integer>[] ar;
    static boolean[] visited;
    static int count=0;
    static int n=0;
    static boolean check = false;
    static void bfs(int now, int depth){
        if(depth == 5 || check == true) {
            check = true;
            return;
        }
        visited[now] = true;
        for (int i = 0; i < ar[now].size(); i++) {
            if(visited[ar[now].get(i)]) continue;
            bfs(ar[now].get(i), depth+1);
        }
        visited[now] = false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ar = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            ar[i] = new ArrayList<>();
        }
        visited = new boolean[n];
        for(int i=0; i<m; ++i){
            st = new StringTokenizer(buf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ar[u].add(v);
            ar[v].add(u);
        }
        for (int i = 0; i < n; i++) {
            bfs(i,1);
        }
        if(check == true) System.out.println(1);
        else System.out.println(0);
    }
}
