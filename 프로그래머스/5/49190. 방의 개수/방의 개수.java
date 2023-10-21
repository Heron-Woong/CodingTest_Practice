import java.util.*;

class Solution {
    private static final int dx[] = {0,1,1,1,0,-1,-1,-1};
    private static final int dy[] = {1,1,0,-1,-1,-1,0,1};
    
    public static class  Vertex{
        public final int y;
        public final int x;
        public final String id;
        public final Set<String> connectedVertices;
        
        public Vertex(int y, int x){
            this.y = y;
            this.x = x;
            this.id = id(y,x);
            this.connectedVertices = new HashSet<>();
        }
        
        public static String id(int y, int x){
            return String.format("(%d, %d)", y, x);
        }
    }
    
    public int solution(int[] arrows) {
        int answer = 0;
        Map<String, Vertex> vertices = new HashMap<>();
        Vertex v = new Vertex(0, 0);
        vertices.put(v.id, v);
        
        for(int d : arrows){
            for(int i = 0; i < 2; ++i){
                int ny = v.y + dy[d];
                int nx = v.x + dx[d];
                String id = Vertex.id(ny,nx);
                
                if(!vertices.containsKey(id)){
                    vertices.put(id, new Vertex(ny, nx));
                } 
                else if(!v.connectedVertices.contains(id)){
                    ++answer;
                }
                
                Vertex u = vertices.get(id);
                v.connectedVertices.add(u.id);
                u.connectedVertices.add(v.id);
                v = vertices.get(id);
            }
            
        }
        return answer;
    }
}