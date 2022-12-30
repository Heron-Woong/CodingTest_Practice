import java.util.*;

public class 백준_11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs)
                return o1 > o2 ? 1 : -1;
            else
                return first_abs - second_abs;
        } );
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            if(num == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }
                else {
                    int a = pq.poll();
                    System.out.println(a);
                }
            }
            else {
                pq.add(num);
            }
        }
    }
}

//양수	첫번째 매개변수가 더 큰 값으로 판단
//0	같은 값으로 판단
//음수	첫번째 매개변수가 더 작은 값으로 판단