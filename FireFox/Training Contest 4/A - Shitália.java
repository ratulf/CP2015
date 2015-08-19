import java.io.*;
import java.math.BigDecimal;
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
        long n = in.nextLong();
        long R = in.nextLong();
        long r = in.nextLong();
        double a = 1.0 * r * Math.sin(Math.PI / n) * R * n;
        out.println(a);
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