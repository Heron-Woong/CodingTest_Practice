import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> graph[] = new ArrayList[n+1];
        boolean visited[] = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n -1; i++) {
            st = new StringTokenizer(buf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        visited[1] = true;
        int parrent[] = new int[n+1];

        while(!dq.isEmpty()) {
            int now = dq.removeFirst();
            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if(visited[next]) continue;;
                visited[next] = true;
                parrent[next] =  now;
                dq.addLast(next);
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parrent[i]);
        }

    }
}