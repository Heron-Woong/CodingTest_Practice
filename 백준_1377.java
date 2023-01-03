import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_1377 {
    static class Node implements Comparable<Node> {
        public int value;
        public int index;
        public Node(int value, int index){
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(Node o){
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Node arr[] = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(Integer.parseInt(bufferedReader.readLine()),i);
        }
        Arrays.sort(arr);
        int max=0;
        for (int i = 0; i < n; i++) {
            max = Math.max((arr[i].index-i),max);
        }
        System.out.println(max+1);
    }
}
