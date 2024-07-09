import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int [] dx = {+1, 0, -1 ,0};
    static int [] dy = {0, -1, 0 ,+1};

    public static void main(String[] args) throws Exception{
        char [] orders = br.readLine().toCharArray();
        int x = 0, y= 0;
        int dir = 3;
        for (char ch : orders) {
            switch (ch) {
                case 'R':
                    dir = (dir + 1) % 4;
                    break;
                case 'L':
                    dir = (dir - 1 >= 0 ?dir - 1:3);
                    break;
                case 'F':
                    x += dx[dir];
                    y += dy[dir];
                    break;
            }
        }
        sb.append(String.format("%d %d", x, y));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}