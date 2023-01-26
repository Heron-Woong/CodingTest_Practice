import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11657 {
    static class Edge{
        int start, end, edge;
        public Edge(int start, int end, int edge){
            this.start = start;
            this.end = end;
            this.edge = edge;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Edge edges[] =  new Edge[m+1]; //Edge 리스트
        long distance[] = new long[n+1]; // 정답 배열
        for(int i =1; i<n+1; ++i){
            distance[i] = Long.MAX_VALUE; //정답 배열은 무한으로 초기화
        }
        //Edge 배열 초기호ㅓㅏ
        for(int i=0; i<m; ++i){
            st = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a,b,c);
        }
        distance[1] =0; //출발 노드는 0으로 초기화
        for(int i=1; i<n; ++i) { //노드 갯수 -1 번 반복
            for(int j=0; j<m; ++j){
                //정답 배열의 값이 무한이면 탐색 금지
                if(distance[edges[j].start] != Long.MAX_VALUE &&
                        distance[edges[j].start]+edges[j].edge < distance[edges[j].end]){
                    distance[edges[j].end] = distance[edges[j].start]+edges[j].edge;
                }
            }
        }
        //음수 사이클인지 검사
        boolean check= true;
        for(int i=0; i<m; ++i){
            if(distance[edges[i].start] != Long.MAX_VALUE &&
                    distance[edges[i].start]+edges[i].edge < distance[edges[i].end]){
                check = false; //정답 배열이 또 업데이트 된거면 음수 사이클이 존재한다.
                break;
            }
        }
        if(check == false) System.out.println(-1);
        else {
            for(int i=2; i<n+1; ++i){
                if(distance[i] == Long.MAX_VALUE) System.out.println(-1);
                else System.out.println(distance[i]);
            }
        }
    }
}
