import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];

        for (int i = 0 ; i < N ; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0 ; i < 2; i++) {
            StringTokenizer se = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(se.nextToken()) - 1;
            int e = Integer.parseInt(se.nextToken()) - 1;
            
            int shiftIdx = e + 1;
            int targetIdx = s;
            while (shiftIdx < N) {
                if (nums[shiftIdx] != 0) {
                    nums[targetIdx] = nums[shiftIdx];
                    targetIdx += 1;
                }
                shiftIdx += 1;
            }
            while (targetIdx < N) {
                nums[targetIdx] = 0;
                targetIdx += 1;
            }
        }
        int count = 0;
        for (int i = 0 ; i < N ; i++) {
            if (nums[i] != 0) {
                count += 1;
                sb.append(nums[i]);
                sb.append("\n");
            }
        }
        bw.write(String.format("%d\n", count));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}