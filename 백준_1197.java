import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1197 {
    static class Edge implements Comparable<Edge>{
        private int a;
        private int b;
        private int c;
        public Edge(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c- o.c;
        }
    }
    static int arr[];
    public static void main(String []args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        arr = new int[v+1];
        for(int i=1; i<v+1; ++i){
            arr[i] = i;
        }
        for(int i =0; i<e; ++i){
            st = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b,c));
        }
        int useEdge =0;
        int result=0;
        while(useEdge < v-1) {
           Edge edge = edges.poll();
           if (find(edge.a) != find(edge.b)) {
                 union(edge.a, edge.b);
                 result += edge.c;
                 useEdge++;
           }
        }
        System.out.println(result);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return;
        else arr[b] = a;

    }
    public static int find(int a){
        if(arr[a] == a) return a;
        else return arr[a] = find(arr[a]);
    }
}
