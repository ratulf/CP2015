import java.io.*;
import java.util.*;

/*
 *  Copyright C-helper
 */
public class Main {
    public static void main(String[] args) {
        InputStream iStream = System.in;
        OutputStream oStream = System.out;
        InputReader in = new InputReader(iStream);
        PrintWriter out = new PrintWriter(oStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
}

class Task {
    public void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        boolean[][] state = new boolean[n + 1][k + 1];
        boolean[][] trace = new boolean[n + 1][k + 1];
        state[0][0] = true;
        for (int i = 1; i <= n; i++) {
            boolean ok = false;
            for (int j = 0; j <= k; j++) {
                if (state[i - 1][j]) {
                    if (j + a[i - 1] <= k && !state[i][j + a[i - 1]]) {
                        state[i][j + a[i - 1]] = true;
                        trace[i][j + a[i - 1]] = true;
                        ok = true;
                    }
                    if (j - a[i - 1] >= 0 && !state[i][j - a[i - 1]]) {
                        state[i][j - a[i - 1]] = true;
                        trace[i][j - a[i - 1]] = false;
                        ok = true;
                    }
                }
            }
            if (i == n || !ok) {
                int l = ok ? n : i - 1;
                out.println(l);
                for (int j = 0; j <= k; j++) {
                    if (state[l][j]) {
                        StringBuilder path = new StringBuilder();
                        int val = j;
                        for (int z = l; z > 0; z--) {
                            if (trace[z][val]) {
                                path.append("+");
                                val -= a[z - 1];
                            } else {
                                path.append("-");
                                val += a[z - 1];
                            }
                        }
                        out.println(path.reverse().toString());
                        return;
                    }
                }
            }
        }
    }
}

class InputReader {
    StringTokenizer token;
    BufferedReader reader;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String next() {
        while (token == null || !token.hasMoreTokens()) {
            try {
                token = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return token.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public int[] nextArrInt(int n) {
        int[] out = new int[n];
        for (int i = 0; i < n; i++)
            out[i] = nextInt();
        return out;
    }

    public long[] nextArrLong(int n) {
        long[] out = new long[n];
        for (int i = 0; i < n; i++)
            out[i] = nextLong();
        return out;
    }
}