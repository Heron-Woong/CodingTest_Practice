import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_2252 {
    static ArrayList<Integer> ar[];
    static int pro[];
    static Deque<Integer> dq;
    public static void path(int start){
        for(int i=0; i<ar[start].size(); ++i){
            if(pro[ar[start].get(i)] > 0) pro[ar[start].get(i)]--;
            if(pro[ar[start].get(i)] == 0) dq.addLast(ar[start].get(i));
        }
    }
    public static void main(String []args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ar = new ArrayList[n+1];
        pro = new int[n+1];
        dq = new ArrayDeque<>();
        ArrayList<Integer> sol = new ArrayList<>();
        for(int i =0; i<=n; ++i){
            ar[i] = new ArrayList<>();
        }
        //그래플 만들고 in-degree을 count 해준다.
        for(int i =0; i<m; ++i){
            st = new StringTokenizer(buf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ar[u].add(v);
            pro[v]++;
        }
        //in-degree가 0인 것부터 모든 deque에 넣어준다.
        for(int i=1; i<n+1; ++i){
            if(pro[i] == 0) dq.addLast(i);
        }
        while(!dq.isEmpty()){
            int start = dq.removeFirst();
            sol.add(start);
            path(start);
        }
        for(int i =0; i<sol.size(); ++i){
            System.out.print(sol.get(i) + " ");
        }
    }
}
