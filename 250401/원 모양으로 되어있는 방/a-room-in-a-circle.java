import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int answer = Integer.MAX_VALUE;
        for (int start = 0 ; start < n ; start++) {
            int step = 0;
            for (int d = 0 ; d < n ; d++) {
                int cur = (start + d) % n;
                step += (d * arr[cur]);
            }
            answer = Math.min(answer, step);
        }
        System.out.print(answer);
    }
}