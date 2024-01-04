import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = buf.readLine();
            if(words.contains(str)) continue;
            words.add(str);
        }
        Collections.sort(words, (w1, w2) -> {
            if(w1.length() == w2.length()) return w1.compareTo(w2);
            return  w1.length() - w2.length();
        });
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
    }
}