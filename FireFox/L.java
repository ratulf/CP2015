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
        int[][] a = new int[3][n];
        int[] count = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            int difa = Math.abs(a[0][i] - a[2][i]);
            int difb = Math.abs(a[1][i] - a[2][i]);
            if (difa < difb) {
                count[0]++;
            } else if (difb < difa) {
                count[1]++;
            }
        }
        out.printf("%d %d\n", count[0], count[1]);
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