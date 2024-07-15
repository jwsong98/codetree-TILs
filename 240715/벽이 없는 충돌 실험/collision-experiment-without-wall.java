import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static double [] dx = {+1, 0, -1, 0};
    static double [] dy = {0, +1, 0, -1};

    static class Pos {
        double x;
        double y;
        Pos(double x, double y) {
            this.x = x;
            this.y = y;
        }
        void move(int d) {
            x = x + dx[d] * 0.5;
            y = y + dy[d] * 0.5;
        }
        @Override
        public int hashCode() {
            return (int)Math.floor(this.x * 2000.0 + this.y * 2.0);
        }
        @Override
        public boolean equals(Object o) {
            Pos p = (Pos)o;
            return (p.x == x && p.y == y);
        }
        boolean isOut() {
            return (this.x < -1000 || this.x > 1000 || this.y < -1000 || this.y > 1000);
        }
    }

    static class Node {
        Pos pos;
        int w;
        int d;
        int i;
        Node(int x, int y, int w, int d, int i) {
            this.pos = new Pos(x, y);
            this.w = w;
            this.d = d;
            this.i = i;
        }
        
        void move() {
            this.pos.move(d);
        }

        static public Node bigger(Node l, Node r) {
            if (l.w > r.w) return l;
            if (l.w < r.w) return r;
            if (l.i > r.i) return l;
            if (l.i < r.i) return r;
            return r;
        }
    }

    public static void main(String[] args) throws Exception {
        Map<String, Integer> dMap = new HashMap<String, Integer>(){{
            put("R", 0);
            put("U", 1);
            put("L", 2);
            put("D", 3);
        }};
        int T = Integer.parseInt(br.readLine());
        for (int t = 0 ; t < T ; t++) {
            int timer = 0;
            int lastCollision = -1;
            int N = Integer.parseInt(br.readLine());
            Queue<Node> q = new ArrayDeque<>();

            for (int i = 0 ; i < N; i++) {
                StringTokenizer tkn = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(tkn.nextToken());
                int y = Integer.parseInt(tkn.nextToken());
                int w = Integer.parseInt(tkn.nextToken());
                int d = dMap.get(tkn.nextToken());
                
                q.offer(new Node(x, y, w, d, i));
            }

            int size = q.size();
            while (size != 0) {
                Map<Pos, Node> mapper = new TreeMap<>();

                timer += 1;
                for (int i = 0 ; i < size; i++) {
                    Node node = q.poll();
                    node.move();

                    if (node.pos.isOut()) {
                        continue;
                    }
                    Node old = mapper.get(node.pos);
                    if (old == null) {
                        mapper.put(node.pos, node);
                    }
                    else {
                        Node bigger = Node.bigger(node, old);
                        mapper.replace(node.pos, bigger);
                        lastCollision = timer;
                    }
                }
                Collection<Node> vSet = mapper.values();
                for (Iterator<Node> iter = vSet.iterator(); iter.hasNext();) {
                    Node node = iter.next();
                    q.offer(node);
                }
                size = q.size();
            }
            sb.append(lastCollision);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}