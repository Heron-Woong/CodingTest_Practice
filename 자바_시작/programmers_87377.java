import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class programmers_87377 {
    private static class Point{
        //데이터를 나타내는 클래스이므로 final 키워드 사용(불병성 가짐)
        public final long x, y;
        private Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    // 교차점 구하기
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2){
        double x = (double) (b1*c2 - b2*c1) / (a1*b2 - a2*b1);
        double y = (double) (a2*c1 - a1*c2) / (a1*b2 - a2*b1);
        if(x % 1 == 0 && y % 1 == 0) return new Point((long) x, (long) y);
        return null;
    }

    //최솟값 구하기
    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        for(Point p : points){
            x = Math.min(x, p.x);
            y = Math.min(y, p.y);
        }
        return new Point(x,y);
    }

    //최댓값 구하기
    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        for(Point p : points){
            x = Math.max(x, p.x);
            y = Math.max(y, p.y);
        }
        return new Point(x,y);
    }
    public String[] main(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if(intersection != null){
                    points.add(intersection);
                }
            }
        }

        Point max = getMaximumPoint(points);
        Point min = getMinimumPoint(points);

        int width = (int) (max.x - min.x + 1);
        int height = (int) (max.y - min.y + 1);

        // char 1차원 배열 한번에 다채우기
        char[][] arr = new char[height][width];
        for(char[] row : arr){
            Arrays.fill(row, '.');
        }

        for(Point p : points){
            int x = (int) (p.x - min.x);
            int y = (int) (max.y - p.y);
            arr[y][x] = '*';
        }

        // char 1 row를 모두 String으로 변경
        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }


        return result;
    }
}
