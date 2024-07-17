import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N = 0;
    static int minPath = Integer.MAX_VALUE;
    static Pos [] coinPos = null; 
    static Pos start = null;
    static Pos end = null;

    static class Pos implements Comparable<Pos>{
        int r;
        int c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public int compareTo(Pos p) {
            if (p.r > r) return 1;
            if (p.r < r) return -1;
            return p.c - c;
        }
    }

    static int countPath(Pos s, Pos e) {
        return Math.abs(s.r - e.r) + Math.abs(s.c - e.c);
    }

    /*
        nextIdx번째 동전을 선택하는 함수, visited하지 않은 동전
    */
    static void selectCoinPos(int [] coins, int nextIdx) {
        if (nextIdx == 3) {
            Pos startPoint = start;
            int curPath = 0;
            for (int i = 0 ; i < 3; i++) {
                Pos next = coinPos[coins[i]];
                curPath += countPath(startPoint, next);
                startPoint = next;
            }
            curPath += countPath(startPoint, end);

            minPath = Math.min(minPath, curPath);
            return;
        }

        int startIdx = 1;
        if (nextIdx >= 1) {
            startIdx = coins[nextIdx - 1] + 1;
        }

        for (int c = startIdx ; c < coinPos.length; c++) {
            if (coinPos[c] == null) continue;
            coins[nextIdx] = c;
            selectCoinPos(coins, nextIdx + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        coinPos = new Pos[10];
        int [] coinIdx = new int[3];

        for (int r = 0 ; r < N ; r++) {
            char [] row = br.readLine().toCharArray();
            for (int c = 0 ; c < N ; c++) {
                char id = row[c];

                if ('0' <= id && id <= '9') {
                    coinPos[id - '0'] = new Pos(r, c);
                } else if(id == 'S') {
                    start = new Pos(r, c);
                } else if (id == 'E') {
                    end = new Pos(r, c);
                }
            }
        }
        selectCoinPos(coinIdx, 0);
        minPath = (minPath == Integer.MAX_VALUE ? -1 : minPath);
        sb.append(minPath);
	    bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}