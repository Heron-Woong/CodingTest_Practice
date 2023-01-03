import java.util.Scanner;

public class 백준_1427 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int arr[] = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i,i+1));
        }
        int max=0;
        int index=0;
        for (int i = 0; i < str.length(); i++) {
            max=0;
            for (int j = i; j < str.length(); j++) {
                if(max < arr[j]){
                    max = arr[j];
                    index =j;
                }
            }
            if(arr[i] < max) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.print(arr[i]);
        }
    }
}
