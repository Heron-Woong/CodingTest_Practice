import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 백준_1043 {
    static ArrayList<Integer> ar[];
    static int pro[];
    public static void main(String []args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st  = new StringTokenizer(bf.readLine());
        int know = Integer.parseInt(st.nextToken());
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<know; ++i){
            hs.add(Integer.parseInt(st.nextToken()));
        }
        ar = new ArrayList[m+1];
        for(int i =1; i<=m; ++i){
            ar[i] = new ArrayList<>();
        }
        pro = new int[n+1];
        for(int i =1; i<=n; ++i){
            pro[i] = i;
        }
        int count = 0;
        for(int i =1; i <=m; ++i){
            st  = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j<num; ++j){
                int p = Integer.parseInt(st.nextToken());
                ar[i].add(p);
            }
        }
        //union
        int temp = 0;
        while(true) {
            for (int i = 1; i <= m; ++i) {
                for (int j = 0; j < ar[i].size() - 1; ++j) {
                    for (int k = 1; k < ar[i].size(); ++k) {
                        union(ar[i].get(j), ar[i].get(k));
                    }
                }
            }
            ++temp;
            if(temp == m) break;
        }
        HashSet<Integer> rs = new HashSet<>();
        for(int num : hs){
            for(int i = 1; i< pro.length; ++i){
                if(pro[i] == pro[num]) rs.add(i);
            }
        }
        for(int i =1; i<=m; ++i){
            for(int j =0; j<ar[i].size(); ++j){
                if(rs.contains(ar[i].get(j))) {
                    ++count;
                    break;
                }
            }
        }
        System.out.println(m-count);
    }
    public static void union(int a, int b){
         a= find(a);
         b= find(b);
         if(a == b) return;
         pro[b] = a;
    }
    public static int find(int a){
        if(pro[a]==a) return a;
        return pro[a] = find(pro[a]);
    }
}
