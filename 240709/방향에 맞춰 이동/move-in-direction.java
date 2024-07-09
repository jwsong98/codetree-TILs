import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int [] dx = {+1, 0, -1 ,0};
    static int [] dy = {0, -1, 0 ,+1};

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int x = 0, y= 0;
        for (int i = 0 ; i < N ; i++) {
            StringTokenizer numsTkn = new StringTokenizer(br.readLine());
            int d = -1;
            switch (numsTkn.nextToken()) {
                case "N":
                    d = 3;
                    break;
                case "E":
                    d = 0;
                    break;
                case "S":
                    d = 1;
                    break;
                case "W":
                    d = 2;
                    break;
            }
            int walk = Integer.parseInt(numsTkn.nextToken()); 
            x += dx[d] * walk;
            y += dy[d] * walk;
        }
        sb.append(String.format("%d %d", x, y));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}