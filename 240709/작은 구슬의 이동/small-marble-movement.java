import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int [] dr = {-1, 0, 0 ,+1};
    static int [] dc = {0, +1, -1 ,0};

    static class Pos {
        int r;
        int c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        Map<String, Integer> dirMap = new HashMap<String, Integer>() { {
            put("U", 0);
            put("R", 1);
            put("L", 2);
            put("D", 3);
        }};
            
        ;
        StringTokenizer nt = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nt.nextToken()), T = Integer.parseInt(nt.nextToken());

        StringTokenizer rct = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(rct.nextToken()) - 1, c = Integer.parseInt(rct.nextToken()) - 1;
        
        int d = dirMap.get(rct.nextToken());
        for (int t = 0 ; t < T ; t++) {
            int nr = r + dr[d], nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                d = 3 - d;
                continue;
            }
            r = nr;
            c = nc;
        }
        sb.append(String.format("%d %d", r + 1, c + 1));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}