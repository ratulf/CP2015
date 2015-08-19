import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskI solver = new TaskI();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskI {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int m = in.nextInt();
            int na = in.nextInt();
            int nb = in.nextInt();
            long T = in.nextLong();
            long[] a = new long[na];
            long[] b = new long[nb];
            for (int i = 0; i < na; i++) {
                a[i] = in.nextLong();
            }
            for (int i = 0; i < nb; i++) {
                b[i] = in.nextLong();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            if (MaxFlowFordFulkerson.maxFlow(buildGraph(a, b, m, T), (na + nb) * 2,
                    (na + nb) * 2 + 1) >= m
                    || MaxFlowFordFulkerson.maxFlow(buildGraph(b, a, m, T),
                    (na + nb) * 2, (na + nb) * 2 + 1) >= m) {
                out.println("S");
            } else {
                out.println("N");
            }
        }

        int[][] buildGraph(long[] a, long[] b, int m, long T) {
            int na = a.length;
            int nb = b.length;
            int base = na * 2;
            int[][] graph = new int[(na + nb + 1) * 2][(na + nb + 1) * 2];
            for (int i = 0; i < na; i++) {
                graph[i][out(i, na)] = 1;
            }
            for (int i = 0; i < nb; i++) {
                graph[base + i][out(i, nb) + base] = 1;
                if (i < m) {
                    graph[out(i, nb) + base][(na + nb) * 2 + 1] = 1;
                }
            }
            for (int i = 0; i < m; i++) {
                graph[(na + nb) * 2][na - i - 1] = 1;
            }
            for (int i = 0; i < na; i++) {
                for (int j = 0; j < nb; j++) {
                    if (Math.abs(a[i] - b[j]) < T) {
                        graph[out(i, na)][base + j] = 1;
                        graph[out(j, nb) + base][i] = 1;
                    }
                }
            }
            return graph;
        }

        int out(int node, int n) {
            return node + n;
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }

    static class MaxFlowFordFulkerson {
        public static int maxFlow(int[][] cap, int s, int t) {
            for (int flow = 0; ; ) {
                int df = findPath(cap, new boolean[cap.length], s, t,
                        Integer.MAX_VALUE);
                if (df == 0)
                    return flow;
                flow += df;
            }
        }

        static int findPath(int[][] cap, boolean[] vis, int u, int t, int f) {
            if (u == t)
                return f;
            vis[u] = true;
            for (int v = 0; v < vis.length; v++)
                if (!vis[v] && cap[u][v] > 0) {
                    int df = findPath(cap, vis, v, t, Math.min(f, cap[u][v]));
                    if (df > 0) {
                        cap[u][v] -= df;
                        cap[v][u] += df;
                        return df;
                    }
                }
            return 0;
        }

    }
}