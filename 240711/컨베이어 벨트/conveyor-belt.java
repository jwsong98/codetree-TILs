import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        StringTokenizer nt = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nt.nextToken());
        int T = Integer.parseInt(nt.nextToken());
        int [][] belt = new int [2][N];
        
        for (int r = 0 ; r < 2; r++) {
            StringTokenizer tkn = new StringTokenizer(br.readLine());    
            for (int i = 0 ; i < N ;i++) {
                belt[r][i] = Integer.parseInt(tkn.nextToken());
            }
        }

        for (int t = 0 ; t < T; t++) {
            int rightBottom = belt[1][N - 1];
            for (int c = N - 1 ; c >= 1 ; c--) {
                belt[1][c] = belt[1][c - 1];
            }
            belt[1][0] = belt[0][N - 1];
            for (int c = N - 1 ; c >= 1; c--) {
                belt[0][c] = belt[0][c - 1];
            }
            belt[0][0] = rightBottom;
        }

        for (int r = 0 ; r < 2 ; r++) {
            for (int c = 0 ; c < N ; c++) {
                sb.append(belt[r][c]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}