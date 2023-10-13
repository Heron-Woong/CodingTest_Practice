import java.util.*;
import java.io.*;

public class Main {
    public static class Time implements Comparable<Time>{
        int s,e;
        public Time(int s, int e){
            this.s = s;
            this.e = e;
        }
        public int compareTo(Time t){
            if(this.s == t.s) return this.e - t.e;
            else return this.s - t.s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Time> arr = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            st = new StringTokenizer(buf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new Time(s, e));
        }

        Collections.sort(arr);

        PriorityQueue<Time> pq = new PriorityQueue<>((c1, c2) -> {
            if(c1.e == c2.e) return c1.s - c2.s;
            else return c1.e - c2.e;
        });

        pq.add(arr.get(0));
        int answer = 1;
        for(int i = 1; i < n; ++i){
            Time now = pq.peek();
            if(now.e > arr.get(i).s) {
                ++answer;
                pq.add(arr.get(i));
            }
            else {
                pq.poll();
                pq.add(arr.get(i));
            }
        }
        System.out.println(answer);
    }
}