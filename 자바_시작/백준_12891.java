import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_12891 {
    static int arr[];
    static int ans[];
    static int checkSelect;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int s = Integer.parseInt(stringTokenizer.nextToken());
        int p = Integer.parseInt(stringTokenizer.nextToken());
        char A[] = new char[s];
        A = bufferedReader.readLine().toCharArray();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            if(arr[i]==0) ++checkSelect;
        }
        int count =0;
        ans = new int[4];
        int j=0;
        for (int i = 0; i < p; i++) {
           Add(A[i]);
        }
        if(checkSelect == 4){
            ++count;
        }
        for (int i = p; i < s; i++) {
            j = i - p;
            Add(A[i]);
            Remove(A[j]);
            if (checkSelect == 4) {
                ++count;
            }
        }
        System.out.println(count);
    }

    private static void Add(char c){
        switch (c){
            case 'A':
                ans[0]++;
                if(arr[0] == ans[0])
                    ++checkSelect;
                break;
            case 'C':
                ans[1]++;
                if(arr[1] == ans[1])
                    ++checkSelect;
                break;
            case 'G':
                ans[2]++;
                if(arr[2] == ans[2])
                    ++checkSelect;
                break;
            case 'T':
                ans[3]++;
                if(arr[3] == ans[3])
                    ++checkSelect;
                break;
        }
    }

    private static void Remove(char c){
        switch (c){
            case 'A':
                if(arr[0] == ans[0])
                    --checkSelect;
                ans[0]--;
                break;
            case 'C':
                if(arr[1] == ans[1])
                    --checkSelect;
                ans[1]--;
                break;
            case 'G':
                if(arr[2] == ans[2])
                    --checkSelect;
                ans[2]--;
                break;
            case 'T':
                if(arr[3] == ans[3])
                    --checkSelect;
                ans[3]--;
                break;
        }
    }
}
