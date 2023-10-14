import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Deque<Integer> dq = new ArrayDeque<>();
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < str.length(); ++i){
            if(str.charAt(i) == '(') dq.add(i);
            else {
                if(dq.isEmpty()) continue;
                if(dq.getLast() + 1 == i) {
                    arr.add(i);
                    dq.removeLast();
                }
                else {
                    int s = dq.removeLast();
                    int e = i;
                    for(int j = 0; j < arr.size(); ++j){
                        if(s < arr.get(j) && arr.get(j) < e) ++answer;
                    }
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}