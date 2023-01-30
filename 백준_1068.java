import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_1068 {
    public static void main(String []args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(buf.readLine());
        int delete = Integer.parseInt(st.nextToken());
        ArrayList<Integer> tree[] = new ArrayList[n];
        boolean visited[] = new boolean[n];
        for(int i=0; i<n; ++i){
            tree[i] = new ArrayList<>();
        }
        int root=0;
        for(int i=0; i<n; ++i){
            if(arr[i] == -1) root =i;
            else{
                tree[i].add(arr[i]);
                tree[arr[i]].add(i);
            }
        }
        int count=0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(root);
        boolean check = true;
        while(!dq.isEmpty()){
            int now = dq.removeFirst();
            visited[now] = true;
            check = true;
            for(int i=0; i<tree[now].size(); ++i){
                int next = tree[now].get(i);
                if(visited[next]) continue;
                visited[next] = true;
                if(next != delete) {
                    dq.addLast(next);
                    check = false;
                }
            }
            if(check == true) ++count;
        }
        if(root == delete) count =0;
        System.out.println(count);
    }
}
