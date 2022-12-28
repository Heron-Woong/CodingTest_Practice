import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class 백준_11003 {
    static class Node {
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
        public int value;
        public int index;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Deque<Node> dq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(stringTokenizer.nextToken());
            while(!dq.isEmpty() && dq.getLast().value > now){
                dq.removeLast();
            }
            dq.addLast(new Node(now,i));
            if(dq.getFirst().index <= i-L){
                dq.removeFirst();
            }
            bufferedWriter.write(dq.getFirst().value + " ");
        }
        bufferedWriter.flush();
        bufferedReader.close();
    }
}
