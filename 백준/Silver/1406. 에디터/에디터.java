import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        String str = st.nextToken();
        Stack<Character> leftSt = new Stack<>();
        Stack<Character> rightSt = new Stack<>();
        for(int i = 0; i < str.length(); ++i){
            leftSt.add(str.charAt(i));
        }
        st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; ++i){
            st = new StringTokenizer(buf.readLine());
            char now = st.nextToken().charAt(0);
            char temp;
            if(now == 'L'){
                if(leftSt.isEmpty()) continue;
                temp = leftSt.pop();
                rightSt.add(temp);
            }
            else if(now == 'D'){
                if(rightSt.isEmpty()) continue;
                temp = rightSt.pop();
                leftSt.add(temp);
            }
            else if(now == 'B'){
                if(leftSt.isEmpty()) continue;
                leftSt.pop();
            }
            else {
                char plus = st.nextToken().charAt(0);
                leftSt.add(plus);
            }
        }
        StringBuilder sb = new StringBuilder();
        int lSize = leftSt.size();
        int rSize = rightSt.size();
        for(int i = 0; i < lSize; ++i){
            sb.append(leftSt.pop());
        }
        sb = sb.reverse();
        for(int i = 0; i < rSize; ++i){
            sb.append(rightSt.pop());
        }
        System.out.println(sb.toString());
    }
}