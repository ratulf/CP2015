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
        int m = in.nextInt();
        int[] need = in.nextArrInt(n);
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + need[i - 1];
        }
        int[] upper = new int[n + 1];
        int tmp = 0;
        for (int i = 1; i <= n; i++) {
            while (tmp < sums[i])
                tmp += m;
            upper[i] = tmp;
        }

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int nMonth = in.nextInt();
            int max = nMonth * m;
            for (int j = 1; j <= n; j++) {
                if (max < sums[j]) {
                    out.println(j - 1 + " " + (max - sums[j - 1]));
                    break;
                } else if (j == n) {
                    out.println(n + " " + (upper[n] - sums[n]));
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