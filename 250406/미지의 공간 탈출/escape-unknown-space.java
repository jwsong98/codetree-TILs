import java.util.*;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static class Pos {
        int plain;
        int r;
        int c;

        Pos (int p, int r, int c) {
            this.plain = p;
            this.r = r;
            this.c = c;
        }
        Pos to(int nr, int nc) {
            return new Pos(plain, nr, nc);
        }
    };
    static int N;
    static int M;
    static int F;
    
    // 0 : 동, 1: 서, 2: 남, 3: 북,  4: 윗면, 5: 바닥면
    static int [] dr = {0, 0, +1, -1};
    static int [] dc = {+1, -1, 0, 0};

    static int [][] buttom = null;
    static int [][][] wall = null;

    static interface Mover {
        Pos move(Pos from, int d);
    }
    static abstract class WallMover implements Mover {
        protected abstract Pos leftOver(Pos from);
        protected abstract Pos upOver(Pos from);
        protected abstract Pos rightOver(Pos from);
        protected abstract Pos downOver(Pos from);


        public Pos move(Pos from, int d) {
            int nr = from.r + dr[d], nc = from.c + dc[d];

            if (nr < 0) {
                return upOver(from);
            }
            if (nc < 0) {
                return leftOver(from);
            }
            if (nr == M) {
                return downOver(from);
            }
            if (nc == M) {
                return rightOver(from);
            }
            return from.to(nr, nc);
        }
    }

    static class TopMover extends WallMover {
        protected Pos leftOver(Pos from) {
            return new Pos(1, 0, from.r);
        }
        protected Pos upOver(Pos from) {
            return new Pos(3, 0, M - 1 - from.c);
        }
        protected Pos rightOver(Pos from) {
            return new Pos(0, 0, M - 1 - from.r);
        }
        protected Pos downOver(Pos from) {
            return new Pos(2, 0, from.c);
        }
    }

    static class SouthMover extends WallMover {

        SouthMover(int r, int c) {
            this.r = r;
            this.c = c;
        }
        int r;
        int c;

        protected Pos leftOver(Pos from) {
            return new Pos(1, from.r, M - 1);
        }
        protected Pos upOver(Pos from) {
            return new Pos(4, M - 1, from.c);
        }
        protected Pos rightOver(Pos from) {
            return new Pos(0, from.r, 0);
        }
        protected Pos downOver(Pos from) {
            return new Pos(5, r + 1, c + from.c);
        }
    }

    static class NorthMover extends WallMover {
        int r;
        int c;
        NorthMover(int r, int c) {
            this.r = r;
            this.c = c;
        }
        protected Pos leftOver(Pos from) {
            return new Pos(0, from.r, M - 1);
        }
        protected Pos upOver(Pos from) {
            return new Pos(4, M - 1, from.c);
        }
        protected Pos rightOver(Pos from) {
            return new Pos(1, from.r, 0);
        }
        protected Pos downOver(Pos from) {
            return new Pos(5, r - 1, c + from.c);
        }
    }

    static class EastMover extends WallMover {
        int r;
        int c;

        EastMover(int r, int c) {
            this.r = r;
            this.c = c;
        }
        protected Pos leftOver(Pos from) {
            return new Pos(2, from.r, M - 1);
        }
        protected Pos upOver(Pos from) {
            return new Pos(4, M - 1 - from.c, M - 1);
        }
        protected Pos rightOver(Pos from) {
            return new Pos(3, from.r, 0);
        }
        protected Pos downOver(Pos from) {
            return new Pos(5, r + N - 1 - from.r, c + 1);
        }
    }

    static class WestMover extends WallMover {
        int r;
        int c;

        WestMover(int r, int c) {
            this.r = r;
            this.c = c;
        }
        protected Pos leftOver(Pos from) {
            return new Pos(3, from.r, M - 1);
        }
        protected Pos upOver(Pos from) {
            return new Pos(4, from.c, 0);
        }
        protected Pos rightOver(Pos from) {
            return new Pos(2, from.r, 0);
        }
        protected Pos downOver(Pos from) {
            return new Pos(5, r + from.r, c - 1);
        }
    }
    
    static class ButtomMover implements Mover {
        int tr;
        int br;
        int lc;
        int rc;

        ButtomMover(int tr, int br, int lc, int rc) {
            this.tr = tr;
            this.br = br;
            this.lc = lc;
            this.rc = rc;
        }

        public Pos move(Pos from, int d) {
            int nr = from.r + dr[d], nc = from.c + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                return null;
            }
            int cur = getState(from);
            int nxt = buttom[nr][nc];
            if (cur != 3 && nxt == 3) {
                switch(d) {
                    case 1: // east
                        return new Pos(0, M - 1, M - 1 - (nr - tr));
                    case 0:
                        return new Pos(0, M - 1, nr - tr);
                    case 2:
                        return new Pos(3, M - 1, M - 1 - (nc - lc));
                    case 3:
                        return new Pos(2, M - 1, nc - lc);
                }
            }
            return from.to(nr, nc);
        }
    }

    static class MovelImpl implements Mover {
        Mover [] movers = new Mover[6];
        MovelImpl (Mover e, Mover w, Mover s, Mover n, Mover t, Mover b) {
            movers[0] = e;
            movers[1] = w;
            movers[2] = s;
            movers[3] = n;
            movers[4] = t;
            movers[5] = b;
        }
        public Pos move(Pos from, int d) {
            Mover mover = movers[from.plain];
            return mover.move(from, d);
        }
    }

    static class DiffusePos extends Pos {
        int dir;
        int spe;

        DiffusePos(int r, int c, int dir, int spe) {
            super(5, r, c);
            this.dir = dir;
            this.spe = spe;
        }
    }
    
    static int getState(Pos pos) {
        switch (pos.plain) {
            case 5:
                return buttom[pos.r][pos.c];
            default:
                return wall[pos.plain][pos.r][pos.c];
        }
    }
    static void setState(Pos pos, int state) {
        switch (pos.plain) {
            case 5:
                buttom[pos.r][pos.c] = state;
                return;
            default:
                wall[pos.plain][pos.r][pos.c] = state;
                return;
        }
    }

    /* 
        1. 시간 이상 현상 확장
        2. 타임머신 이동

        각 면별로 벗어났을 때 이동하는 곳
        윗면:
            동 : (r, n - 1) -> 동 단면 (0, r)
            서 : (r, n - 1) -> 서 단면 (0, r)
            북 : (n - 1, c) -> 북 단면 (0, c)
            남 : (n - 1, c) -> 남 단면 (0, c)
        동면:
            (r, n - 1) -> 
    */
    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        F = sc.nextInt();
        buttom = new int [N][N];

        for (int r = 0; r < N ; r++) {
            for (int c = 0 ; c < N ; c++) {
                buttom[r][c] = sc.nextInt();
            }
        }
        wall = new int[5][M][M];
        
        Pos start = new Pos(4, -1, -1);
        Pos end = new Pos(5, -1, -1);

        int tr = -1, br = -1, lc = -1, rc = -1;

        for (int d = 0; d < 5; d++) {
            for (int r = 0; r < M; r++) {
                for (int c = 0 ; c < M ; c++) {
                    wall[d][r][c] = sc.nextInt();

                    switch (wall[d][r][c]) {
                        case 2:
                            start.r = r;
                            start.c = c;
                            break;
                        case 4:
                            end.r = r;
                            end.c = c;
                            break;
                        case 3:
                            if (tr == -1 && lc == -1) {
                                tr = r;
                                lc = c;
                            }
                            if (wall[d][r + 1][c] != 3 && wall[d][r][c + 1] != 3) {
                                br = r;
                                rc = c;
                            }
                            break;
                    }
                }
            }
        }
        Mover mover = new MovelImpl(
            new EastMover(tr, lc),
            new WestMover(tr, rc),
            new SouthMover(br, lc),
            new NorthMover(tr, lc),
            new TopMover(),
            new ButtomMover(tr, br, lc, rc)
        );
        wall[start.plain][start.r][start.c] = -1;
        boolean isFinish = false;
        int answer = -1;

        Queue<Pos> q = new LinkedList();
        
        Queue<DiffusePos> diffuse = new LinkedList<>();
        for (int i = 0 ; i < F ; i++) {
            int r = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt(), v = sc.nextInt();
            diffuse.offer(new DiffusePos(r, c, d, v));
        } 

        q.offer(start);
        while (!isFinish) {
            if (q.isEmpty()) {
                isFinish = true;
                break;
            }
            int qSize = diffuse.size();
            for (int i = 0 ; i < qSize ; i++) {
                DiffusePos dPos = diffuse.poll();

                Pos curPos = dPos;
                boolean isBlock = false;
                for (int step = 0 ; step < dPos.spe && isBlock; step++) {
                    int curState = getState(curPos);
                    switch (curState) {
                        case 1:
                        case 4:
                            isBlock = false;
                            break;
                        default:
                            setState(curPos, 5);
                            break;
                    }
                    curPos = mover.move(curPos, dPos.dir);
                }
                if (!isBlock) {
                    diffuse.offer(new DiffusePos(curPos.r, curPos.c, dPos.dir, dPos.spe));
                }
                
            }

            int nSize = q.size();
            for (int i = 0 ; i < nSize; i++) {
                Pos pos = q.poll();
                int curState = getState(pos);
                for (int d = 0 ; d < 4 ; d++) {
                    Pos newPos = mover.move(pos, d);

                    if (newPos == null) continue;   
                    int nextState = getState(newPos);
                    switch (nextState) {
                        case 0:
                            setState(newPos, curState - 1);
                            q.offer(newPos);
                            break;
                        case 4:
                            answer = -(curState - 1);
                            isFinish = true;
                            break;
                    }
                }
            }
        }

        for (int r = 0 ; r < N ; r++) {
            for (int c = 0 ; c < N ; c++) {
                System.out.printf("%d ", buttom[r][c]);
            }
            System.out.println();
        }
        System.out.println();
 
        for (int d = 0 ; d < 5 ; d++) {
            for (int r = 0 ; r < M ; r++) {
                for (int c = 0 ; c < M ; c++) {
                    System.out.printf("%d ", wall[d][r][c]);
            }
            System.out.println();
        }
        System.out.println();
        }

        System.out.print(answer);
    }
}