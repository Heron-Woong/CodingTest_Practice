import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());

        Set<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(buf.readLine());
            String name = st.nextToken();
            String isEnter = st.nextToken();
            if(isEnter.equals("enter")) {
                hs.add(name);
            }
            else {
                hs.remove(name);
            }
        }

        ArrayList<String> arr = new ArrayList<>(hs);
        Collections.sort(arr, Collections.reverseOrder());
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < arr.size(); i++) {
            bufferedWriter.write(arr.get(i) + "\n");
        }
        bufferedWriter.flush();
    }
}
