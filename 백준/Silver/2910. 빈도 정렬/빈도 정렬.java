import java.io.*;
import java.util.*;

public class Main {
    public static class Num {
        long num; int count; int idx;
        public Num(long num, int count, int idx) {
            this.num = num;
            this.count = count;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Long, Integer> cnt = new HashMap<>();
        st = new StringTokenizer(buf.readLine());
        Map<Long, Integer> idx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(st.nextToken());
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            if(!idx.containsKey(num)) {
                idx.put(num, i);
            }
        }

        ArrayList<Num> nums = new ArrayList<>();
        for(Long num : cnt.keySet()) {
            nums.add(new Num(num, cnt.get(num), idx.get(num)));
        }

        Collections.sort(nums, (n1, n2) -> {
            if(n1.count == n2.count) return n1.idx - n2.idx;
            return n2.count - n1.count;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).count; j++) {
                sb.append(nums.get(i).num + " ");
            }
        }

        System.out.println(sb);

    }
}