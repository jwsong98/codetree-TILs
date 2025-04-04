import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] str = sc.next().toCharArray();

        int answer = 0;

        for (int i = 0 ;  i < n ; i++) {
            if (str[i] != 'C') continue;
            for (int j = i + 1 ; j < n ; j++) {
                if (str[j] != 'O') continue;
                for (int k = j + 1; k < n ; k++) {
                    if (str[k] == 'W') answer += 1;
                }
            }
        }
        System.out.print(answer);
    }
}