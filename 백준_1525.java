import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1525 {
    static int[] dx=new int[]{-1,0,1,0};
    static int[] dy=new int[]{0,-1,0,1};
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer start = new StringBuffer();

        for(int i =0; i<3; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {

                String temp=st.nextToken();
                if(temp.equals("0")) {
                    start.append("9");
                }
                else
                    start.append(temp);
            }
        }
        Deque<String> dq = new ArrayDeque<>();
        Map<String, Integer> m = new HashMap<>();
        dq.addFirst(start.toString());
        m.put(start.toString(),0);
        while(!dq.isEmpty()){
            String now = dq.poll();
            int nine = now.indexOf("9");
            int y = nine/3;
            int x = nine%3;

            for(int i = 0; i<4; ++i){
                int ny = y+dy[i];
                int nx = x +dx[i];
                int move = ny*3+nx;
                if(nx < 0 || nx >=3 || ny <0 || ny >=3) continue;
                StringBuilder next = new StringBuilder(now);

                char temp = next.charAt(move);
                next.setCharAt(nine,temp);
                next.setCharAt(move,'9');
                String nextStr = next.toString();
                if(!m.containsKey(nextStr)){
                    dq.addLast(nextStr);
                    m.put(nextStr,m.get(now)+1);
                }
            }
        }
        if(m.containsKey("123456789")){
            System.out.println(m.get("123456789"));
        }
        else{
            System.out.println(-1);
        }
    }
}
