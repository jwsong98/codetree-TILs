import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int [] dr = {0, 1, 2, 0, 1, 2, 0, 1, 2};
    static int [] dc = {0, 0, 0, 1, 1, 1, 2, 2, 2};
    
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int [][] map = new int[N][N];
        int answer = -1;

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer colNums = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(colNums.nextToken());
            }
        }

        for (int r = 0 ; r < N - 2; r++) {
            for (int c = 0 ; c < N - 2 ; c++) {
                int count = 0;
                for (int i = 0 ; i < 9 ; i++) {
                    if (map[r + dr[i]][c + dc[i]] == 1) {
                        count += 1;
                    }
                }
                if (count > answer) {
                    answer = count;
                }
            }
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        // 여기에 코드를 작성해주세요.
    }
}