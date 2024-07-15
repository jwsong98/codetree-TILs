import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int [] dx = {+1, 0, -1, 0};
    static int [] dy = {0, +1, 0, -1};

    static class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        void move(int d) {
            x = x + dx[d];
            y = y + dy[d];
        }
        @Override
        public int hashCode() {
            return this.x * 3 + this.y * 2;
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
            int lastCollision = -1;
            while (size != 0) {
                Map<Pos, Node> mapper = new HashMap<>();

                timer += 1;
                for (int i = 0 ; i < size; i++) {
                    Node node = q.poll();
                    node.move();

                    Node old = mapper.get(node.pos);
                    if (old == null) {
                        mapper.put(node.pos, node);
                    }
                    else if (Node.bigger(old, node) == node) {
                        mapper.replace(node.pos, node);
                        lastCollision = timer;
                    }
                }
                for (Iterator<Map.Entry<Pos, Node>> iter = mapper.iterator(); mapper.hasNext();) {
                    Map.Entry<Pos, Node> node = iter.next();
                    q.offer(node.getValue());
                }
                size = q.size();
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}