import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int count = 0;
        boolean checked[] = new boolean[str2.length()];
        for(int i = 0; i < str1.length(); ++i){
            for(int j = 0; j < str2.length(); ++j){
                if(checked[j] == true) continue;
                if(str1.charAt(i) == str2.charAt(j)) {
                    ++count;
                    checked[j] = true;
                    break;
                }
            }
        }
        System.out.println(str1.length()-count + str2.length()-count);
    }
}