import java.util.*;

class Solution {
    public static class Pair{
        int index, childs;
        public Pair(int index, int childs){
            this.index = index;
            this.childs = childs;
        }
    }
    static ArrayList<Integer> graphs[];
    static boolean visited[];
    static boolean rights[];
    static int parent[];
    static int answer = 0;
    public int solution(int n, int[][] lighthouse) {
        
        graphs = new ArrayList[n+1];
        visited = new boolean[n+1];
        rights = new boolean[n+1];
        parent = new int[n+1];
        for(int i = 1; i <= n; ++i){
            graphs[i] = new ArrayList<>();
        }
        for(int i = 0; i < lighthouse.length; ++i){
            graphs[lighthouse[i][0]].add(lighthouse[i][1]);
            graphs[lighthouse[i][1]].add(lighthouse[i][0]);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        visited[1] = true;
        while(!dq.isEmpty()){
            int now = dq.removeFirst();
            for(int i = 0; i < graphs[now].size(); ++i){
                int next = graphs[now].get(i);
                if(visited[next]) continue;
                visited[next] = true;
                parent[next] = now;
                dq.add(next);
            }
        }
        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1);
        return answer;
    }
    public void dfs(int now){
        boolean ch = true;
        for(int i = 0; i < graphs[now].size(); ++i){
          int next = graphs[now].get(i);
          if(visited[next]) continue;
          visited[next] = true;
          dfs(next);
        }
        for(int i = 0; i < graphs[now].size(); ++i){
          int next = graphs[now].get(i);
          if(!rights[next]) ch = false; 
        }
        if(ch) return;
        if(rights[now] == true) return;
        if(rights[parent[now]] == false){
            ++answer;
            rights[parent[now]] = true;
        } 
        
    }
}