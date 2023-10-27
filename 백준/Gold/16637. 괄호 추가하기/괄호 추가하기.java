import java.io.*;
import java.util.*;

public class Main {
    public static class Pair{
        int s,e;
        public Pair(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    static ArrayList<Pair> pairs = new ArrayList<>();
    static ArrayList<Integer> arr = new ArrayList<>();
    static String str;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        str = st.nextToken().toString();
        for(int i = 0; i < n; i+=2){
            if(i+3 <= n){
                pairs.add(new Pair(i, i+3));
            }
        }
        for(int i = 1; i < n+1/4; ++i){
            choose(0,i,n, 0);
        }
        if(n == 1) answer = Integer.parseInt(str);
        System.out.println(answer);
    }
    public static int cal(int n){
        int idx = 0;
        int n_idx = 0;
        Deque<String> dq = new ArrayDeque<>();
        while(n_idx < n){
            int res = 0;
            if(idx < arr.size() && n_idx == pairs.get(arr.get(idx)).s ){
                int num1 = str.charAt(n_idx) - '0';
                int num2 = str.charAt(n_idx+2) - '0';
                res = operation(num1, num2, str.substring(n_idx+1,n_idx+2));
                dq.addLast(String.valueOf(res));
                n_idx += 3;
                idx++;
            }
            else {
                dq.addLast(str.substring(n_idx,n_idx+1));
                n_idx++;
            }
        }
        while(dq.size() != 1){
            int num1 = Integer.parseInt(dq.removeFirst());
            String op = dq.removeFirst();
            int num2 = Integer.parseInt(dq.removeFirst());
            int res = operation(num1,num2,op);
            dq.addFirst(String.valueOf(res));
        }

        return Integer.parseInt(dq.removeFirst());
    }
    public static int operation(int num1, int num2, String op){
        if(op.equals("+")){
            return num1 + num2;
        }
        else if(op.equals("-")){
            return num1 - num2;
        }
        else if(op.equals("*")){
            return num1 * num2;
        }
        return 0;
    }
    public static void choose(int curNum, int finish, int n, int start){
        if(curNum == finish){
            answer = Math.max(answer, cal(n));
            return;
        }
        for(int i = start; i < pairs.size(); ++i){
            if(arr.size() != 0){
                if(pairs.get(arr.size()-1).e < pairs.get(i).s){
                    arr.add(i);
                }
                else continue;
            }
            else {
                arr.add(i);
            }
            choose(curNum+1, finish, n, i+1);
            arr.remove(arr.size()-1);
        }
    }
}