import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        
        int countA[] = new int[26];
        int countB[] = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            countA[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            countB[str2.charAt(i) - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            if (countA[i] > countB[i]) {
                ans += countA[i] - countB[i];
            } else {
                ans += countB[i] - countA[i];
            }
        }
        
        System.out.println(ans);
    }
}