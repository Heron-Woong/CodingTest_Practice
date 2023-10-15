import java.util.*;
import java.io.*;

public class Main {
    public static class Ch{
        char c; int idx;
        public Ch(char c, int idx){
            this.c = c;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String ch = sc.next();
        Deque<Ch> dq = new ArrayDeque<>();
        Deque<Ch> temp = new ArrayDeque<>();
        int idx = 0;
        for(int i = 0; i < str.length(); ++i){
            idx = -1;
            for(int j = 0; j < ch.length(); ++j){
                if(ch.charAt(j) == str.charAt(i)){
                    idx = j;
                    break;
                }
            }
            dq.addLast(new Ch(str.charAt(i), idx));
            if(idx >= ch.length()-1){
                boolean check = true;
                if(dq.size() < ch.length()) continue;
                for(int j = ch.length()-1; j >= 0 ; --j){
                    Ch now = dq.getLast();
                    if(now.idx == j){
                        temp.addLast(dq.removeLast());
                    }
                    else{
                        check = false;
                        break;
                    }
                }
                if(!check){
                    int size = temp.size();
                    for(int j = 0; j < size; ++j){
                        dq.addLast(temp.removeLast());
                    }
                }
                temp.clear();
            }

        }
        if(dq.size() == 0) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            int size = dq.size();
            for(int i = 0; i < size; ++i){
                sb.append(dq.removeFirst().c);
            }
            System.out.println(sb.toString());
        }
    }
}