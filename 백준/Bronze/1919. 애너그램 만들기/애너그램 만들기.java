import java.io.*;
import java.util.*;

public class Main {
    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int countA[] = getAlphabetCount(str1);
        int countB[] = getAlphabetCount(str2);

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