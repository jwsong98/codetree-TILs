import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [] a = sc.next().toCharArray();

        for (int i = 0 ; i < a.length ; i++) {
            if (a[i] == '0') {
                a[i] = '1';
                break;
            }
            if (i == (a.length - 1)) {
                a[i] = '0';
            }
        }
        int result = 0;
        for (char ch : a) {
            result <<= 1;
            result |= (ch == '0') ? 0 : 1;
        }
        System.out.print(result);
    }
}