import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }
}

class Task {
    public void solve(int caseNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int[] dp = new int[n];
        dp[0] = a[0];
        for (int i = 1; i < n; i++) {
            if (i - 1 >= 0) {
                dp[i] = Math.max(dp[i], Math.max(a[i], dp[i - 1]));
            }
            if (i - 2 >= 0) {
                dp[i] = Math.max(dp[i], Math.max(a[i], dp[i - 2]));
            }
            if (i - 3 >= 0) {
                dp[i] = Math.max(dp[i], dp[i - 3] + a[i]);
            }
        }
        out.println(dp[n - 1]);
    }
}

class InputReader {
    BufferedReader reader;
    StringTokenizer token;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        token = null;
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
}