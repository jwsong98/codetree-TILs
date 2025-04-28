import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int answer = 0, cur = 0;
        for (int i = 0 ; i < n ; i++) {
            if (arr[i] == 1) {
                cur = i + m;
                i = i + 2 * m;
                answer += 1;
            }
        }
        System.out.print(answer);
    }
}