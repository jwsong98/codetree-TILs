import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

    static class Pos {
        int r;
        int c;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static int N;
    static int M;

    static final int[] dr = {+1, 0, -1, 0};
    static final int[] dc = {0, +1, 0, -1};

    static boolean isValid(int r, int c, int k, int [][] map, boolean [][] visited) {
        return (0 <= r && r < N && 0 <= c && c < M && !visited[r][c] && map[r][c] > k);
    }

    static void dfs(int r, int c, int k, int[][] map, boolean [][] visited) {
        for (int d = 0 ; d < 4 ; d++) {
            int nr = r + dr[d], nc = c + dc[d];

            if (isValid(nr, nc, k, map, visited)) {
                visited[nr][nc] = true;
                dfs(nr, nc, k, map, visited);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer NM = new StringTokenizer(br.readLine());
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());
    
        int [][] map = new int[N][M];

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < M ; c++) {
                map[r][c] = Integer.parseInt(row.nextToken());
            }
        }
    
        int answer = -1, minK = 100;
        for (int k = 1 ; k <= 100; k++ ) {
            int count = 0;
            boolean [][] visited = new boolean[N][M];
            for (int sr = 0 ; sr < N ; sr++) {
                for (int sc = 0; sc < M ; sc++) {
                    if (visited[sr][sc] || map[sr][sc] <= k) continue;
                    count += 1;
                    visited[sr][sc] = true;
                    dfs(sr, sc, k, map, visited);
                }
            }
            if (answer < count) {
                answer = count;
                minK = k;
            }
            if (count == 0) {
                break;
            }
        }
        sb.append(String.format("%d %d", minK, answer));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}