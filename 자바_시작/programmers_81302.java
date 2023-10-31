public class programmers_81302 {
    //위, 왼쪽, 오른쪽, 아래
    private static final int dx[] = {0, -1, 1, 0};
    private static final int dy[] = {1, 0, 0 , -1};

    private boolean isVolunteer(char[][] room, int y, int x, int no){
        for(int d = 0; d < 4; ++d){
            if(d == no) continue;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if(room[ny][nx] == 'P') return true;
        }
        return false;
    }
    private boolean isDistanced(char[][] room, int y, int x){
        for(int d = 0; d < 4; ++d){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            switch(room[ny][nx]){
                case 'P' : return false;
                case 'O' :
                    if(isVolunteer(room, ny, nx, 3-d)) return false;
                    break;
            }
        }
        return true;
    }
    private boolean isDistanced(char[][] room){
        for(int y = 0; y < room.length; ++y){
            for(int x = 0; x <room[y].length; ++x){
                if(room[y][x] != 'P') continue;
                if(!isDistanced(room, y, x)) return false;
            }
        }
        return true;
    }
    public int[] solution(String[][] places) {
        int [] answer = new int[5];
        for(int i = 0; i < places.length; ++i){
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for(int j = 0; j < room.length; ++j){
                room[j] = place[j].toCharArray();
            }
            if(isDistanced(room)){
                answer[i] = 1;
            }
            else{
                answer[i] = 0;
            }
        }
        return answer;
    }
}
