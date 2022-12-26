import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        long arr[] = new long[n];
        long num=0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            num = Long.parseLong(stringTokenizer.nextToken());
            arr[i]=num;
        }
        Arrays.sort(arr);
        long count = 0;
        for (int i = 0; i < n; i++) {
            int start_idx = 0;
            int end_idx = n - 1;
            long find = arr[i];
            while (start_idx < end_idx) {
                if (arr[start_idx] + arr[end_idx] == find) {
                    if(start_idx != i && end_idx != i){
                        ++count;
                        break;
                    }
                    else if(start_idx == i){
                        start_idx++;
                    }
                    else{
                        end_idx--;
                    }
                } else if (arr[start_idx] + arr[end_idx] < find) {
                    ++start_idx;
                }else{
                    --end_idx;
                }
            }
        }
        System.out.println(count);
        bufferedReader.close();
    }
}
