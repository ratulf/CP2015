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
        char[] a = in.next().toCharArray();
        String p = "";
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '.') {
                index = i;
                continue;
            }
            p += a[i];
        }
        int ten = 0;
        if (index != -1) {
            ten = a.length - index;
        }
        long num = Long.parseLong(p);
        long hund = 100;
        for (int i = 1; i < ten; i++) {
            hund *= 10;
        }
        long g = gcd(num, hund - num);
        long res = num / g + (hund - num) / g;
        out.println(res);
    }

    public long gcd(long a, long b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
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