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
    
    static final int[] dr = {+1, 0, -1, 0};
    static final int[] dc = {0, +1, 0, -1};

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int [][] map = new int[N][N];

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < N ; c++) {
                map[r][c] = Integer.parseInt(row.nextToken());
            }
        }
       	
        Stack<Pos> stk = new Stack<>();
        List<Integer> counts = new ArrayList<>();
        boolean [][] visited = new boolean[N][N];

        for (int sr = 0 ; sr < N ; sr++) {
            for (int sc = 0; sc < N ; sc++) {
                if (visited[sr][sc] || map[sr][sc] == 0) continue;
                int count = 1;
                visited[sr][sc] = true;
                stk.add(new Pos(sr, sc));

                while (!stk.isEmpty()) {
                    Pos cur = stk.pop();
                    for (int d = 0 ; d < 4 ; d++) {
                        int nr = cur.r + dr[d], nc = cur.c + dc[d];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 0) {
                            continue;
                        } 
                        count += 1;
                        visited[nr][nc] = true;
                        stk.push(new Pos(nr, nc));
                    }
                }
                counts.add(count);
            }
        }
        sb.append(counts.size());
        sb.append("\n");
        Collections.sort(counts);
        for (int count : counts) {
            sb.append(count);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}