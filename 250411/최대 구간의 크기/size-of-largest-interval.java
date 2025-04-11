import java.util.*;

public class Main {
    static class Point implements Comparable<Point>{
        int p;
        int s;
        Point(int p, int s) {
            this.p = p;
            this.s = s;
        }
        @Override
        public int compareTo(Point oth) {
            return this.p - oth.p; 
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<>();
        int n = sc.nextInt();
        int state = 0;
        int answer = 0;
        int left = 0, right = 0;

        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            points.add(new Point(a, +1));
            points.add(new Point(b, -1));
        }
        Collections.sort(points);

        for (Point point : points) {
//            System.out.printf("%d %d\n", point.p, point.s);
            if (state == 0) {
                left = point.p;
            }
            state += point.s;
            if (state == 0) {
                right = point.p;
                answer = Math.max(answer, right - left);
            }
        }
        System.out.print(answer);
    }
}