import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [] input = sc.next().toCharArray();
        int answer = 0;
        int score = 0;

        for (int i = input.length - 2; i >= 0 ; i--) {
            char front = input[i], back = input[i + 1];

            if (front == ')' && back == ')') {
                score += 1;
            }
            if (front == '(' && back == '(') {
                answer += score;
            }
        }
        System.out.print(answer);
    }
}