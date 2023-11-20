import java.io.*;
import java.util.*;

public class Main {
    public static class score implements Comparable<score>{
        String name = "";
        double num = 0;
        score(String name, double num) {
            this.name = name;
            this.num = num;
        }

        public int compareTo(score s) {
            return (int) (s.num - this.num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int num = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<score> scores = new PriorityQueue<>();
        Map<String, Double> hm = new HashMap<>();

        boolean validateAlphabet[] = new boolean[26];
        int answer[] = new int[26];

        double limit = num * 0.05;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(buf.readLine());
            String name = st.nextToken();
            double selectNum = Double.parseDouble(st.nextToken());
            if(selectNum >= limit) {
                int idx = name.charAt(0) - 'A';
                validateAlphabet[idx] = true;
                hm.put(name, selectNum);
            }
        }

        for (String s : hm.keySet()) {
            for (int i = 1; i <= 14; i++) {
                scores.add(new score(s,  hm.get(s)/i));
            }
        }

        int count = 0;

        while(!scores.isEmpty()) {
            score now = scores.poll();
            int idx = now.name.charAt(0) - 'A';
            answer[idx]++;
            ++count;
            if(count == 14) break;
        }

        for(int i = 0; i < 26; ++i) {
            if(validateAlphabet[i]) {
                System.out.println((char)('A' + i) + " " + answer[i]);
            }
        }
    }
}