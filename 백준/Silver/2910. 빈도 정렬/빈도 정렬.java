import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Long, Integer> cnt = new LinkedHashMap<>();
        st = new StringTokenizer(buf.readLine());

        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(st.nextToken());
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        Long[] frequencies = cnt.keySet().toArray(new Long[cnt.size()]);
        Arrays.sort(frequencies, (f1, f2) -> {
           return cnt.get(f2) - cnt.get(f1);
        });

        StringBuilder sb = new StringBuilder();
        for(long frequency : frequencies) {
            int count = cnt.get(frequency);
            while(count-- > 0) {
                sb.append(frequency + " ");
            }
        }

        System.out.println(sb);

    }
}