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
            if(this.e == t.e) return this.s - t.s;
            else return this.e - t.e;
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

        int answer = 1;
        int now = arr.get(0).e;
        for(int i = 1; i < arr.size(); ++i){
            if(now <= arr.get(i).s){
                ++answer;
                now = arr.get(i).e;
            }
        }
        System.out.println(answer);
    }
}