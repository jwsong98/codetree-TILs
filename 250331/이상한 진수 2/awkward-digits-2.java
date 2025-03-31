import java.util.*;

public class Main {
    static int tryChange(char [] a, int pos) {
       int result = 0;
        for (int i = 0 ; i < a.length ; i++) {
            result <<= 1;
            int tV = 0, fV = 1;
            if (pos == i) {
                tV = 1;
                fV = 0;
            }
            result |= (a[i] == '0') ? tV : fV;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [] a = sc.next().toCharArray();

        int result = Integer.MIN_VALUE;
        for (int i = 0 ; i < a.length ; i++) {
            result = Math.max(result, tryChange(a, i));
        }
        System.out.print(result);
    }
}