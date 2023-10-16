import java.util.*;
import java.io.*;

public class Main {
    public static class Pair implements Comparable<Pair>{
        int m,v;
        public Pair(int m, int v){
            this.m = m;
            this.v = v;
        }
        public int compareTo(Pair p){
            if(this.m == p.m) return p.v - this.v;;
            return this.m - p.m;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Pair> jew = new ArrayList<>();
        ArrayList<Integer> bag = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            st = new StringTokenizer(buf.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jew.add(new Pair(m,v));
        }
        for(int i = 0; i < k; ++i){
            st = new StringTokenizer(buf.readLine());
            bag.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(jew);
        Collections.sort(bag);
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0, j = 0; i < k; ++i){
            while(j < n && jew.get(j).m <= bag.get(i)){
                pq.add(jew.get(j++).v);
            }

            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }
}
