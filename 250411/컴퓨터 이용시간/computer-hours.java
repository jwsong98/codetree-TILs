import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int p;
        int s;
        int i;
        Point (int p, int s, int i) {
            this.p = p;
            this.s = s;
            this.i = i;
        }

        @Override
        public int compareTo(Point oth) {
            return this.p - oth.p;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> points = new ArrayList<>();
        int [] state = new int [n];
        PriorityQueue<Integer> computers = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            points.add(new Point(sc.nextInt(), +1, i));
            points.add(new Point(sc.nextInt(), -1, i));
            computers.offer(i + 1);
        }
        Collections.sort(points);
        for (Point point : points) {
            if (point.s == 1) {
                state[point.i] = computers.poll();  
            }
            else {
                computers.offer(state[point.i]);
            }
        }
        for (int i = 0 ; i < n ; i++) {
            System.out.printf("%d ", state[i]);
        }
    }
}