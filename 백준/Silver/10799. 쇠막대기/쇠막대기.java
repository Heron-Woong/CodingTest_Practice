import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Deque<Integer> dq = new ArrayDeque<>();
        int answer = 0;

        for(int i = 0; i < str.length(); ++i){
            if(str.charAt(i) == '(') dq.add(i);
            else {
                if(dq.isEmpty()) continue;
                if(dq.getLast() + 1 == i) {
                    dq.removeLast();
                    answer += dq.size();
                }
                else {
                    answer += 1;
                    dq.removeLast();
                }
            }
        }
        System.out.println(answer);
    }
}