import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준_1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one =0;
        int zero =0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(num > 1) plusPq.add(num);  //1을 제외한 양수 부분
            else if(num == 1) one++; // 1
            else if(num == 0) zero++; // 0
            else if(num < 0) minusPq.add(num); //음수 부분
        }
        int result =0;

        //양수부분
        while(plusPq.size()>1){
            int first = plusPq.poll();
            int second = plusPq.poll();
            result += first * second;
        }
        if(!plusPq.isEmpty()){
            result += plusPq.poll();
        }

        //음수부분
        while(minusPq.size()>1){
            int first = minusPq.poll();
            int second = minusPq.poll();
            result += first * second;
        }
        if(!minusPq.isEmpty()){
            if(zero != 0){
                result += 0 * minusPq.poll();
                --zero;
            }
            else result += minusPq.poll();
        }
        result += one;
        System.out.println(result);
    }
}
