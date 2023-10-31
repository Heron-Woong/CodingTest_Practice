import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for(int i = 0; i < str.length(); ++i) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                System.out.print((char)('a' + str.charAt(i) - 'A'));
            }
            else System.out.print((char)('A' + str.charAt(i) - 'a'));
        }
    }
}