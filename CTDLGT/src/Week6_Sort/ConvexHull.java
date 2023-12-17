package Week6_Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ConvexHull {
    public static List<Point> getConvexHull(Point[] points){
        if (points.length < 3) {
            throw  new IllegalArgumentException("At least 3 points to create a ConvexHull");
        }
        List<Point> convexHull = new ArrayList<>();

        // tìm điểm góc dưới bên trái
        int leftmost = 0;
        for (int i=1; i< points.length; i++){
            if (points[i].x < points[leftmost].x){
                leftmost = i;
            }
        }

        int current = leftmost;
        int next;
        do {
            convexHull.add(points[current]);
            next = (current + 1) % points.length;

            for (int i=0; i< points.length; i++){
                if (orientation(points[current], points[i], points[next]) < 0){
                    next = i;
                }
            }
            current = next;
        } while (current != leftmost);
        return convexHull;
    }

    private static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0){
            return 0;  // 3 điểm thẳng hàng
        } else if (val > 0){
            return 1;  // ngược chiều kim đồng hồ
        } else return -1;  // theo chiều kim đồng hồ
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for (int i=0; i<n; i++){
            int x_ = sc.nextInt();
            int y_ = sc.nextInt();
            points[i] = new Point(x_, y_);
        }
        List<Point> convexHull = getConvexHull(points);
        for (Point point : convexHull) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }

    }

}
