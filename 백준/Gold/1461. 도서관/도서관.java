import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        PriorityQueue<Integer> plusPq = new PriorityQueue<>((c1,c2) -> {
            return c2 - c1;
        });
        st = new StringTokenizer(buf.readLine());
        for(int i = 0; i < n; ++i){
            int num = Integer.parseInt(st.nextToken());
            if(num < 0) minusPq.add(num);
            else plusPq.add(num);
        }
        int answer = 0;
        int num = 0;
        if(plusPq.size() > 0 && minusPq.size() > 0) num = Math.max(Math.abs(minusPq.peek()), plusPq.peek());
        else {
            if(plusPq.size() > 0) num = plusPq.peek();
            else num = Math.abs(minusPq.peek());
        }
        while(!minusPq.isEmpty()){
            for (int i = 0; i < m; ++i) {
                    int temp = minusPq.poll();
                    if (i == 0) answer += (Math.abs(temp) * 2);
                    if(minusPq.isEmpty()) break;
            }
        }
        while(!plusPq.isEmpty()){
            for (int i = 0; i < m; ++i) {
                int temp = plusPq.poll();
                if (i == 0) answer += (Math.abs(temp) * 2);
                if(plusPq.isEmpty()) break;
            }
        }
        answer -= num;
        System.out.println(answer);
    }
}