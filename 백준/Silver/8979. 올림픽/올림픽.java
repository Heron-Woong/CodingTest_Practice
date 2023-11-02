import java.io.*;
import java.util.*;

public class Main {
    public static class Rank implements Comparable<Rank>{
        int idx, g, s, d, rank;
        public Rank(int idx, int g, int s, int d, int rank) {
            this.idx = idx;
            this.g = g;
            this.s = s;
            this.d = d;
            this.rank = rank;
        }

        public int compareTo(Rank r) {
            if(this.g != r.g) return r.g - this.g;
            if(this.g == r.g) return r.s - this.s;
            return r.d - this.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Rank> ranks = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            st = new StringTokenizer(buf.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            ranks.add(new Rank(idx, g, s ,d, 0));
        }
        Collections.sort(ranks);
        ranks.get(0).rank = 1;
        for(int i = 1; i < ranks.size() ; ++i) {
            if(ranks.get(i-1).g == ranks.get(i).g &&
                    ranks.get(i-1).s == ranks.get(i).s &&
                    ranks.get(i-1).d == ranks.get(i).d) {
                ranks.get(i).rank = ranks.get(i-1).rank;
            }
            else {
                ranks.get(i).rank = ranks.get(i-1).rank + 1;
            }
        }
        int answer = 0;
        for(int i = 0; i < ranks.size() ; ++i) {
            if(ranks.get(i).idx == k) {
                answer = ranks.get(i).rank;
                break;
            }
        }
        System.out.println(answer);
    }
}