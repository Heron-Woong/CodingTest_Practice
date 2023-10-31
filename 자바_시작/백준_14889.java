import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_14889 {
    static boolean visited[];
    static int pro[][];
    static int n;
    static int answer = Integer.MAX_VALUE;
    public static void main(String []args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        pro = new int[n][n];
        for(int i = 0; i<n; ++i){
            st = new StringTokenizer(buf.readLine());
            for(int j = 0; j<n; ++j){
                pro[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol(n/2,0);
        System.out.println(answer);
    }


    public static void sol(int c, int start){
        if(c == 0){
            ArrayList<Integer> st = new ArrayList<>();
            ArrayList<Integer> li = new ArrayList<>();
            for(int i =0; i<n; ++i){
                if(!visited[i]) li.add(i);
                else st.add(i);
            }
            answer = Math.min(answer, dif(st,li));
        }
        for(int i=start; i< n; ++i){
            if(!visited[i]){
               visited[i] = true;
               sol(c-1,i);
               visited[i] = false;
            }
        }
    }

    public static int dif(ArrayList<Integer> start, ArrayList<Integer> link){
        int st = 0;
        int li= 0;
        for(int i =0; i<start.size(); ++i){
            for(int j = 0; j<start.size(); ++j){
                st += pro[start.get(i)][start.get(j)];
            }
        }
        for(int i =0; i<link.size(); ++i){
            for(int j = 0; j<link.size(); ++j){
                li += pro[link.get(i)][link.get(j)];
            }
        }
        return Math.abs(st-li);
    }

}
