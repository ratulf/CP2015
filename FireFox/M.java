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
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        int[] need = new int[n];
        for (int i = 0; i < n; i++) {
            need[i] = in.nextInt();
        }
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = in.nextInt();
        }
        int result = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max((numbers[i] + need[i] - 1) / need[i], max);
        }
        for (int i = 0; i < n; i++) {
            result += (max * need[i] - numbers[i]) * cost[i];
        }
        out.println(result);
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