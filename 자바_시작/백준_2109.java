import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2109 {
    static class Node implements Comparable<Node>{
        int d; int p;
        public Node(int d, int p) {
            this.d = d;
            this.p = p;
        }
        @Override
        public int compareTo(Node o1){
           return Integer.compare(this.d, o1.d); // 앞에게 크면 1 리턴
        }
    }
    public static void main(String [] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> dq = new PriorityQueue<>();
        ArrayList<Node> ar = new ArrayList<>();
        if( n ==0) System.out.println(0);
        else {
            for (int i = 0; i < n; ++i) {
                st = new StringTokenizer(buf.readLine());
                int p = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                ar.add(new Node(d, p));
            }
            Collections.sort(ar);
            int sum = 0;
            dq.add(ar.get(0).p);
            for (int i = 1; i < ar.size(); ++i) {
                if (ar.get(i).d == dq.size()) {
                    if (dq.peek() < ar.get(i).p) {
                        dq.poll();
                        dq.add(ar.get(i).p);
                    }
                } else if (ar.get(i).d > dq.size()) dq.add(ar.get(i).p);
            }
            int size = dq.size();
            for (int i = 0; i < size; ++i) {
                sum += dq.poll();
            }
            System.out.println(sum);
        }
    }
}
