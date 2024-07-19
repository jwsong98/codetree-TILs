import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
    
    static List<Integer>[] edges = null;
    public static void main(String[] args) throws Exception {
        StringTokenizer NM = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());
        edges = new ArrayList[N];

        for (int i = 0 ; i < N ; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            StringTokenizer xy = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(xy.nextToken()) - 1;
            int y = Integer.parseInt(xy.nextToken()) - 1;
            edges[x].add(y);
            edges[y].add(x);
        }

        Stack<Integer> stk = new Stack<>();
        boolean [] visited = new boolean[N];
        int answer = 0;
        stk.push(0);
        visited[0] = true;
        while (!stk.isEmpty()) {
            int cur = stk.pop();

            for (int node : edges[cur]) {
                if (visited[node]) continue;
                visited[node] = true;
                stk.push(node);
                answer += 1;
            }
        }
        sb.append(answer);
        bw.write(sb.toString());
		bw.flush();
		bw.close();
    }
}