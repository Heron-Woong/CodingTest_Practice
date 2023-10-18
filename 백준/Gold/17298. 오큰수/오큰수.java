import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        int answer[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(buf.readLine());
        for(int i = 0; i < n; ++i){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            answer[i] = -1;
        }

        for(int i = 0; i < n; ++i){
           while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
               answer[stack.peek()] = arr[i];
               stack.pop();
           }
           stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; ++i){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}